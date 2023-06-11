package com.udacity.dog.service;

import com.udacity.dog.entity.Dog;
import com.udacity.dog.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogsBread() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreadById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> retriveveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }
}
