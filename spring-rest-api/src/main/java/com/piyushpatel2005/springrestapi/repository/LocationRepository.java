package com.piyushpatel2005.springrestapi.repository;

import com.piyushpatel2005.springrestapi.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
