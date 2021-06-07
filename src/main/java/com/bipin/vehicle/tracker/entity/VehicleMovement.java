package com.bipin.vehicle.tracker.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "movement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  /*  @NotEmpty(message = "Vehicle's name cannot be empty.")
    @Size(min = 5, max = 25)
    private String vehicleName;*/

    @NotEmpty(message = "Vehicle's registered number cannot be empty.")
    @Size(min = 5, max = 25)
    private String vehicleRegNumber;

    @NotEmpty(message = "Vehicle's tracked location cannot be empty.")
    private String locationAddress;

    @NotEmpty(message = "Vehicle's tracker camera cannot be empty.")
    private String cameraName;

    private String movementCapturedDateTime;
}
