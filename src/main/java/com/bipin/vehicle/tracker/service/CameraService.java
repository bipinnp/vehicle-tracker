package com.bipin.vehicle.tracker.service;

import com.bipin.vehicle.tracker.entity.Camera;

import java.util.List;


public interface CameraService {

    Camera findById(Long id);

    List<Camera> findAll();

    Camera create(Camera camera);

    Camera update(Camera camera);

    void deleteById(Long id);
}
