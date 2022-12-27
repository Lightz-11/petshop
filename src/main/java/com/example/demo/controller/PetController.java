package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pet;
import com.example.demo.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {

  @Autowired
  private PetService service;

  @PostMapping
  public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
    return new ResponseEntity<>(service.createPet(pet), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Pet>> getPets() {
    return new ResponseEntity<>(service.getPets(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pet> getPetById(@PathVariable String id) {

    Optional<Pet> petAntigo = service.getPetById(id);

    if (petAntigo.isPresent()) {
      return new ResponseEntity<>(petAntigo.get(), HttpStatus.FOUND);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

  @PutMapping("/{id}")
  public ResponseEntity<Pet> editPetById(@PathVariable String id, @RequestBody Pet pet) {

    Optional<Pet> antigoPet = service.editPetById(id, pet);

    if (antigoPet.isPresent()) {
      return new ResponseEntity<>(antigoPet.get(), HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Pet> deletePetById(@PathVariable String id) {

    Optional<Pet> antigoPet = service.getPetById(id);
    service.deletePetById(id);

    if (antigoPet.isPresent()) {
      return new ResponseEntity<>(antigoPet.get(), HttpStatus.FOUND);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

}
