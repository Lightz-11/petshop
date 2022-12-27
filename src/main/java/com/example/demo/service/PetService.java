package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Pet;

public interface PetService {

  Pet createPet(Pet pet);

  public List<Pet> getPets();

  public Optional<Pet> getPetById(String id);

  Optional<Pet> editPetById(String id, Pet pet);

  void deletePetById(String id);

}
