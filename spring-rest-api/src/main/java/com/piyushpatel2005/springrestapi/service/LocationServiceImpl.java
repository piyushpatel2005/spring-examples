package com.piyushpatel2005.springrestapi.service;

import com.piyushpatel2005.springrestapi.entity.Location;
import com.piyushpatel2005.springrestapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> retrieveLocations() {
        return (List<Location>) locationRepository.findAll();
    }
}
