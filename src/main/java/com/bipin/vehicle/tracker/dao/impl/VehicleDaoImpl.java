package com.bipin.vehicle.tracker.dao.impl;

import com.bipin.vehicle.tracker.dao.VehicleDao;
import com.bipin.vehicle.tracker.entity.Vehicle;
import com.bipin.vehicle.tracker.exception.ResourceNotFoundException;
import com.bipin.vehicle.tracker.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class VehicleDaoImpl implements VehicleDao {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", id));
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Vehicle update(Vehicle vehicle) {
       Vehicle vehicle1 = vehicleRepository.findById(vehicle.getId()).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", vehicle.getId()));
       vehicle1.setName(vehicle.getName());
       vehicle1.setRegisteredNumber(vehicle.getRegisteredNumber());
       return vehicleRepository.save(vehicle1);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(Long id) {
      if(!vehicleRepository.existsById(id)) {
          throw new ResourceNotFoundException("Vehicle", "id", id);
      }
      vehicleRepository.deleteById(id);
    }
}
