package com.piyushpatel2005.springtesting.service;


import com.piyushpatel2005.springtesting.entity.Location;
import com.piyushpatel2005.springtesting.exception.LocationNotFoundException;
import com.piyushpatel2005.springtesting.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> retrieveLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public Location retrieveLocation(long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);

        if(optionalLocation.isPresent())
            return optionalLocation.get();
        else
            throw new LocationNotFoundException();
    }
}
