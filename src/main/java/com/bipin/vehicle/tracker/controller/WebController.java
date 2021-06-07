package com.bipin.vehicle.tracker.controller;

import com.bipin.vehicle.tracker.entity.Camera;
import com.bipin.vehicle.tracker.entity.Location;
import com.bipin.vehicle.tracker.entity.Vehicle;
import com.bipin.vehicle.tracker.entity.VehicleMovement;
import com.bipin.vehicle.tracker.repository.CameraRepository;
import com.bipin.vehicle.tracker.repository.LocationRepository;
import com.bipin.vehicle.tracker.repository.VehicleRepository;
import com.bipin.vehicle.tracker.service.CameraService;
import com.bipin.vehicle.tracker.service.LocationService;
import com.bipin.vehicle.tracker.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/web" })
public class WebController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CameraService cameraService;
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CameraRepository cameraRepository;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/home")
    public String getHome(@RequestParam("username") String username,
                       @RequestParam("password") String password, Model model){
        if (username.equals("admin") && password.equals("admin"))
        {
            return "home";
        }
        else
            return "home";
    }
    @GetMapping("/location")
    public String getLocationPage(Model model) {
        Location location = new Location();
        model.addAttribute("location", location);
        return "location";
    }

    @GetMapping("/camera")
    public String getCameraPage(Model model) {
        Camera camera = new Camera();
        model.addAttribute("camera", camera);
        List<Location> locationList = locationService.findAll();
        model.addAttribute("locations", locationList);
        return "camera";
    }

    @GetMapping("/vehicle")
    public String getVehiclePage(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "vehicle";
    }

    @GetMapping("/movement")
    public String getVehicleMovementPage(Model model) {
        List<String> vehicleRegNums = vehicleService.findAll().stream()
                .map(Vehicle::getRegisteredNumber).collect(Collectors.toList());
        List<String> locationAddresses = locationService.findAll().stream()
                .map(Location::getAddress).collect(Collectors.toList());
        List<String> locationCameras = cameraService.findAll().stream()
                .map(Camera::getName).collect(Collectors.toList());

        model.addAttribute("vehicles", vehicleRegNums);
        model.addAttribute("locations", locationAddresses);
        model.addAttribute("cameras", locationCameras);
        model.addAttribute("movement", new VehicleMovement());
        return "movement";
    }

    @PostMapping("/camera/add")
    public String saveCamera(@ModelAttribute("camera") Camera camera) {
        cameraService.create(camera);
        return "home";
    }
    @PostMapping("/location/add")
    public String saveLocation(@ModelAttribute("location") Location location) {
        locationService.create(location);
        return "home";
    }

    @PostMapping("/vehicle/add")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.create(vehicle);
        return "home";
    }

    @PostMapping("/movement/add")
    public String saveMovement(@ModelAttribute("movement") VehicleMovement vehicleMovement, Model model) {
        System.out.println("vcccccc: " + vehicleMovement);
        model.addAttribute("movement", vehicleMovement);
        return "movement-success";
    }
}
