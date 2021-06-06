package com.bipin.vehicle.tracker.service.impl;

import com.bipin.vehicle.tracker.entity.Vehicle;
import com.bipin.vehicle.tracker.service.VehicleService;
import com.bipin.vehicle.tracker.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public Vehicle findById(Long id) {
        return vehicleDao.findById(id);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleDao.findAll();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return vehicleDao.create(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return vehicleDao.update(vehicle);
    }

    @Override
    public void deleteById(Long id) {
      vehicleDao.deleteById(id);
    }
}
