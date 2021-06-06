package com.bipin.vehicle.tracker.dao.impl;

import com.bipin.vehicle.tracker.dao.LocationDao;
import com.bipin.vehicle.tracker.entity.Location;
import com.bipin.vehicle.tracker.exception.ResourceNotFoundException;
import com.bipin.vehicle.tracker.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class LocationDaoImpl implements LocationDao {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Location create(Location location) {
        return locationRepository.save(location);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Location update(Location location) {
        Location location1 = locationRepository.findById(location.getId()).orElseThrow(() -> new ResourceNotFoundException("Location", "id", location.getId()));
        location1.setAddress(location.getAddress());
        return locationRepository.save(location1);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(Long id) {
        if(!locationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Location", "id", id);
        }
        locationRepository.deleteById(id);
    }
}
