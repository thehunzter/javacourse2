package com.udacity.dog.service;

import com.udacity.dog.entity.Dog;

import java.util.List;

public interface DogService {
    public List<Dog> retrieveDogs();
    public List<String> retrieveDogsBread();

    public String retrieveDogBreedById(Long id);
    public List<String> retriveveDogNames();
}
