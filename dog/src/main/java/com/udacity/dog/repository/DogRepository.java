package com.udacity.dog.repository;

import com.udacity.dog.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository  extends CrudRepository<Dog, Long> {

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreadById(Long id);

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findDogById(Long id);

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
}
