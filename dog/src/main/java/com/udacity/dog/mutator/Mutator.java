package com.udacity.dog.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dog.entity.Dog;
import com.udacity.dog.repository.DogRepository;
import com.udacity.dog.service.GraphQLBreedNotFoundException;
import com.udacity.dog.service.GraphQLDogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutator implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutator(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for (Dog d: allDogs) {
            if (d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new GraphQLBreedNotFoundException("Breed Not Found", breed);
        }

        return true;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            // Set the new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new GraphQLDogNotFoundException("Dog Not Found", id);
        }
    }
}
