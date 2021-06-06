package com.bipin.vehicle.tracker.dao;

import com.bipin.vehicle.tracker.entity.Location;

import java.util.List;

public interface LocationDao {
    Location findById(Long id);

    List<Location> findAll();

    Location create(Location location);

    Location update(Location location);

    void deleteById(Long id);
}
