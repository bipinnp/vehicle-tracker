package com.bipin.vehicle.tracker.dao;

import com.bipin.vehicle.tracker.entity.Camera;

import java.util.List;

public interface CameraDao {

    Camera findById(Long id);

    List<Camera> findAll();

    Camera create(Camera camera);

    Camera update(Camera camera);

    void deleteById(Long id);
}
