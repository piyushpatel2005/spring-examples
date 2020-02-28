package com.piyushpatel2005.springtesting.service;

import com.piyushpatel2005.springtesting.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> retrieveLocations();

    Location retrieveLocation(long id);
}
