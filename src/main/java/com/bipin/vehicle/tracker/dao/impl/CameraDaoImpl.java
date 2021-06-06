package com.bipin.vehicle.tracker.dao.impl;

import com.bipin.vehicle.tracker.dao.CameraDao;
import com.bipin.vehicle.tracker.entity.Camera;
import com.bipin.vehicle.tracker.entity.Location;
import com.bipin.vehicle.tracker.exception.ResourceNotFoundException;
import com.bipin.vehicle.tracker.repository.CameraRepository;
import com.bipin.vehicle.tracker.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CameraDaoImpl implements CameraDao {

    @Autowired
    private CameraRepository cameraRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Camera findById(Long id) {
        return cameraRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Camera","id", id));
    }

    @Override
    public List<Camera> findAll() {
        return cameraRepository.findAll();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Camera create(Camera camera) {
        Location location = locationRepository.findById(camera.getLocationId()).orElseThrow(() -> new ResourceNotFoundException("Location", "id", camera.getLocationId()));
        camera.setLocation(location);
        return cameraRepository.save(camera);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Camera update(Camera camera) {
        Location location = locationRepository.findById(camera.getLocationId()).orElseThrow(() -> new ResourceNotFoundException("Location", "id", camera.getLocationId()));
        Camera camera1 = cameraRepository.findById(camera.getId()).orElseThrow(() -> new ResourceNotFoundException("Camera","id", camera.getId()));
        camera1.setLocation(location);
        camera1.setName(camera.getName());
        return cameraRepository.save(camera);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(Long id) {
        if(!cameraRepository.existsById(id)) {
            throw new ResourceNotFoundException("Camera","id", id);
        }
        cameraRepository.deleteById(id);
    }
}
