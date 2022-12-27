package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {

  @Autowired
  private PetRepository repo;

  @Override
  public Pet createPet(Pet pet) {
    return repo.save(pet);
  }

  @Override
  public List<Pet> getPets() {
    return repo.findAll();
  }

  @Override
  public Optional<Pet> getPetById(String id) {
    return repo.findById(id);
  }

  @Override
  public Optional<Pet> editPetById(String id, Pet pet) {

    Optional<Pet> petAntigo = repo.findById(id);

    if (petAntigo.isPresent()) {
      pet.setId(id);
      return Optional.of(repo.save(pet));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public void deletePetById(String id) {
    repo.deleteById(id);
  }

}
