package com.piyushpatel2005.springrestapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.piyushpatel2005.springrestapi.entity.Dog;
import com.piyushpatel2005.springrestapi.exception.DogNotFoundException;
import com.piyushpatel2005.springrestapi.exception.DogNotFoundGraphException;
import com.piyushpatel2005.springrestapi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DogQuery implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public DogQuery(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundGraphException("Dog not found", id);
        }
    }
}
