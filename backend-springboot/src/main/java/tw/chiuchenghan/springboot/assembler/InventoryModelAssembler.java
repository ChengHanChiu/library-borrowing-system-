package tw.chiuchenghan.springboot.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import tw.chiuchenghan.springboot.controller.InventoryController;
import tw.chiuchenghan.springboot.entity.Inventory;

@Component
public class InventoryModelAssembler implements RepresentationModelAssembler<Inventory, EntityModel<Inventory>> {

  @Override
  public EntityModel<Inventory> toModel(Inventory inventory) {

    return EntityModel.of(inventory, //
//        linkTo(methodOn(InventoryController.class).one(inventory.getId())).withSelfRel(),
        linkTo(methodOn(InventoryController.class).all()).withRel("inventory"));
  }
}