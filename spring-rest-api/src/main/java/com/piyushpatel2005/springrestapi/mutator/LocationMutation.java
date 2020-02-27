package com.piyushpatel2005.springrestapi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.piyushpatel2005.springrestapi.entity.Location;
import com.piyushpatel2005.springrestapi.exception.LocationNotFoundException;
import com.piyushpatel2005.springrestapi.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocationMutation implements GraphQLMutationResolver {
    private LocationRepository locationRepository;

    public LocationMutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address) {
        Location location = new Location(name, address);
        locationRepository.save(location);
        return location;
    }

    public boolean deleteLocation(Long id) {
        locationRepository.deleteById(id);
        return true;
    }

    public Location updateLocationName(String name, Long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if(optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setName(name);
            locationRepository.save(location);
            return location;
        } else {
            throw new LocationNotFoundException("Location not found", id);
        }
    }
}
