package com.bipin.vehicle.tracker.dao;

import com.bipin.vehicle.tracker.entity.Vehicle;

import java.util.List;

public interface VehicleDao {
    Vehicle findById(Long id);

    List<Vehicle> findAll();

    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    void deleteById(Long id);
}
