package com.bipin.vehicle.tracker.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name="registeredNumber", unique = true, nullable = false)
    private String registeredNumber;

}
