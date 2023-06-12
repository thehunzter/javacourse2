package com.udacity.dog.resolve;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dog.entity.Dog;
import com.udacity.dog.repository.DogRepository;
import com.udacity.dog.service.DogNotFoundException;
import com.udacity.dog.service.GraphQLDogNotFoundException;
import graphql.servlet.GraphQLQueryProvider;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;
    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        }
        throw new GraphQLDogNotFoundException("Dog Not Found", id);
    }
}
