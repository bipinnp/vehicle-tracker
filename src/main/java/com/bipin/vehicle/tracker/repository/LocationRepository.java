package com.bipin.vehicle.tracker.repository;

import com.bipin.vehicle.tracker.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository  extends JpaRepository<Location,Long> {
}
