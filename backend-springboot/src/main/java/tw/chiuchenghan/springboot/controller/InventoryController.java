package tw.chiuchenghan.springboot.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.chiuchenghan.springboot.entity.Inventory;
import tw.chiuchenghan.springboot.entity.Book;
import tw.chiuchenghan.springboot.repository.BookRepository;
import tw.chiuchenghan.springboot.repository.InventoryRepository;
import tw.chiuchenghan.springboot.assembler.InventoryModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;




@RestController
public class InventoryController {

  private final InventoryRepository repository;
  
  private final BookRepository bookRepository;

  private final InventoryModelAssembler assembler;

  InventoryController(InventoryRepository repository, BookRepository bookRepository, InventoryModelAssembler assembler) {
    this.repository = repository;
    this.bookRepository =bookRepository;
    this.assembler = assembler;
  }
  
  @GetMapping("/api/inventory")
  public CollectionModel<EntityModel<Inventory>> all() {

    List<EntityModel<Inventory>> inventoryModels = repository.findAll().stream()
		.map(assembler::toModel) //
		.collect(Collectors.toList());
    
    inventoryModels.forEach(inventoryModel -> {
        String isbn = inventoryModel.getContent().getISBN();
        Optional<Book> bookOptional = bookRepository.findByISBN(isbn);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            Link bookLink = Link.of("/api/book/" + book.getISBN()); 
            inventoryModel.add(bookLink);
            
            Link nameLink = Link.of(book.getName()).withRel("name");
            Link authorLink = Link.of(book.getAuthor()).withRel("author");
            Link introduction = Link.of(book.getIntroduction()).withRel("introduction");
            inventoryModel.add(authorLink);
            inventoryModel.add(nameLink);
            inventoryModel.add(introduction);
            
        }
        
    });

    return CollectionModel.of(inventoryModels, linkTo(methodOn(InventoryController.class).all()).withSelfRel());
  }	
  
//  @GetMapping("/api/login")
//  EntityModel<User> pa(@RequestParam String telephone) {
//
//    User user = repository.findByPhoneNumber(telephone) //
//        .orElseThrow(() -> new UserNotFoundException(telephone));
//
//    return assembler.toModel(user);
//  }
  
  
}