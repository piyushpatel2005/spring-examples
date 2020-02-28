package com.piyushpatel2005.springtesting.repository;

import com.piyushpatel2005.springtesting.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
