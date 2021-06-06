package com.bipin.vehicle.tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackerReport {

    private String vehicleNumber;
    private String location;
    private String cameraDetails;

}
