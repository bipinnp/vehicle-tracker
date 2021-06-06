package com.bipin.vehicle.tracker.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Camera> cameraList = new ArrayList<>();
}
