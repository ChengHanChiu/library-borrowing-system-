package tw.chiuchenghan.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tw.chiuchenghan.springboot.entity.Book;
import tw.chiuchenghan.springboot.entity.Inventory;
import tw.chiuchenghan.springboot.entity.User;
import tw.chiuchenghan.springboot.exception.UserNotFoundException;
import tw.chiuchenghan.springboot.repository.BookRepository;
import tw.chiuchenghan.springboot.repository.InventoryRepository;
import tw.chiuchenghan.springboot.assembler.BookModelAssembler;
import tw.chiuchenghan.springboot.assembler.InventoryModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;




@RestController
public class BookController {

  
  private final BookRepository repository;

  private final BookModelAssembler assembler;

  BookController(BookRepository repository, BookModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }
  
  @GetMapping("/book/{id}")
  public EntityModel<Book> one(@PathVariable String id) {

    Book book = repository.findByISBN(id) //
        .orElseThrow(() -> new UserNotFoundException(id));

    return assembler.toModel(book);
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