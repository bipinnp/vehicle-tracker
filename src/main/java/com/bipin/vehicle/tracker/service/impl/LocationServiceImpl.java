package com.bipin.vehicle.tracker.service.impl;

import com.bipin.vehicle.tracker.entity.Location;
import com.bipin.vehicle.tracker.service.LocationService;
import com.bipin.vehicle.tracker.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;

    @Override
    public Location findById(Long id) {
        return locationDao.findById(id);
    }

    @Override
    public List<Location> findAll() {
        return locationDao.findAll();
    }

    @Override
    public Location create(Location location) {
        return locationDao.create(location);
    }

    @Override
    public Location update(Location location) {
        return locationDao.update(location);
    }

    @Override
    public void deleteById(Long id) {
        locationDao.deleteById(id);
    }
}
