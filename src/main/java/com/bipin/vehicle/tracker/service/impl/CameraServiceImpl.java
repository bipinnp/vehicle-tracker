package com.bipin.vehicle.tracker.service.impl;

import com.bipin.vehicle.tracker.entity.Camera;
import com.bipin.vehicle.tracker.service.CameraService;
import com.bipin.vehicle.tracker.dao.CameraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraDao cameraDao;

    @Override
    public Camera findById(Long id) {
        return cameraDao.findById(id);
    }

    @Override
    public List<Camera> findAll() {
        return cameraDao.findAll();
    }

    @Override
    public Camera create(Camera camera) {
        return cameraDao.create(camera);
    }

    @Override
    public Camera update(Camera camera) {
        return cameraDao.update(camera);
    }

    @Override
    public void deleteById(Long id) {
        cameraDao.deleteById(id);
    }
}
