package tw.chiuchenghan.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.chiuchenghan.springboot.entity.User;
import tw.chiuchenghan.springboot.entity.UserDto;
import tw.chiuchenghan.springboot.exception.UserNotFoundException;
import tw.chiuchenghan.springboot.repository.UserRepository;
import tw.chiuchenghan.springboot.service.UserService;
import tw.chiuchenghan.springboot.assembler.UserModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;




@RestController
public class UserController {

  private final UserRepository repository;

  @Autowired
  private UserService userService;

  
  private final UserModelAssembler assembler;

  UserController(UserRepository repository, UserModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }
  
  @GetMapping("/api/users")
  public CollectionModel<EntityModel<User>> all() {

    List<EntityModel<User>> users = repository.findAll().stream()
		.map(assembler::toModel) //
		.collect(Collectors.toList());

    return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
  }
  
//  @GetMapping("/api/login")
//  EntityModel<User> pa(@RequestParam String telephone) {
//
//    User user = repository.findByPhoneNumber(telephone) //
//        .orElseThrow(() -> new UserNotFoundException(telephone));
//
//    return assembler.toModel(user);
//  }
  
  @GetMapping("/api/login")
  public ResponseEntity<String> verifyUser(@RequestParam String telephone, String password) {
	  userService.verifyPassword(telephone, password);
	  return ResponseEntity.ok("User logged in successfully");
  }
  
  @PostMapping("/api/register")
  public ResponseEntity<String> createUser(@RequestBody @Valid UserDto newUserDto) {
      userService.registerUser(newUserDto);
      return ResponseEntity.ok("User registered successfully");
  }

  // Single user
  
  @GetMapping("/user/{id}")
  public EntityModel<User> one(@PathVariable Long id) {

    User user = repository.findById(id) //
        .orElseThrow(() -> new UserNotFoundException(id));

    return assembler.toModel(user);
  }

  @PutMapping("/users/{id}")
  ResponseEntity<?> replaceUser(@RequestBody User newUser, @PathVariable Long id) {

    User updatedUser = repository.findById(id) //
        .map(User -> {
          User.setName(newUser.getName());
          User.setPhoneNumber(newUser.getPhoneNumber());
          return repository.save(User);
        }) //
        .orElseGet(() -> {
          newUser.setId(id);
          return repository.save(newUser);
        });

    EntityModel<User> entityModel = assembler.toModel(updatedUser);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  @DeleteMapping("/Users/{id}")
  ResponseEntity<?> deleteUser(@PathVariable Long id) {

    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }
  
  
}