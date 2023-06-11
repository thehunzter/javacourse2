package com.udacity.dog.resolve;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dog.entity.Dog;
import com.udacity.dog.repository.DogRepository;
import graphql.servlet.GraphQLQueryProvider;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;
    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Iterable<String> findDogById(Long id) {
        return dogRepository.findBreadById(id);
    }
}
