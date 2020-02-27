package com.piyushpatel2005.springrestapi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.piyushpatel2005.springrestapi.entity.Dog;
import com.piyushpatel2005.springrestapi.exception.BreedNotFoundException;
import com.piyushpatel2005.springrestapi.exception.DogNotFoundGraphException;
import com.piyushpatel2005.springrestapi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DogMutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public DogMutation (DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for (Dog d: allDogs) {
            if(d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not found", breed);
        }
        return deleted;
    }

    public Dog updateDogName( String newname, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newname);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundGraphException("Dog not found", id);
        }
    }
}
