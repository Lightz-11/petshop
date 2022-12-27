package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {

}