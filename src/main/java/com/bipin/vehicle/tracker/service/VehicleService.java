package com.bipin.vehicle.tracker.service;

import com.bipin.vehicle.tracker.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle findById(Long id);

    List<Vehicle> findAll();

    Vehicle create(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    void deleteById(Long id);
}
