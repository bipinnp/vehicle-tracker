package com.bipin.vehicle.tracker.service;

import com.bipin.vehicle.tracker.entity.Location;
import java.util.List;

public interface LocationService  {
    Location findById(Long id);

    List<Location> findAll();

    Location create(Location location);

    Location update(Location location);

    void deleteById(Long id);

}
