package com.piyushpatel2005.springrestapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.piyushpatel2005.springrestapi.entity.Location;
import com.piyushpatel2005.springrestapi.repository.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class LocationQuery implements GraphQLQueryResolver {

    private LocationRepository locationRepository;

    public LocationQuery(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}
