package com.piyushpatel2005.DogMicroservice.repository;

import com.piyushpatel2005.DogMicroservice.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
