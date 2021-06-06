package com.bipin.vehicle.tracker.controller;

import com.bipin.vehicle.tracker.entity.Camera;
import com.bipin.vehicle.tracker.entity.Location;
import com.bipin.vehicle.tracker.entity.Vehicle;
import com.bipin.vehicle.tracker.service.CameraService;
import com.bipin.vehicle.tracker.service.LocationService;
import com.bipin.vehicle.tracker.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CameraService cameraService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/home")
    public String getHome(@RequestParam("username") String username,
                       @RequestParam("password") String password){
        if (username.equals("admin") && password.equals("admin"))
        {
            return "home";
        }
        else
            return "login";
    }
    @GetMapping("/location")
    public String getLocationPage(Model model) {
        Location location = new Location();
        model.addAttribute("location", location);
        return "location";
    }

    @GetMapping("/camera")
    public String getCameraPAge(Model model) {
        Camera camera = new Camera();
        model.addAttribute("camera", camera);
        return "camera";
    }

    @GetMapping("/vehicle")
    public String getVehiclePage(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "vehicle";
    }

    @PostMapping("/camera/add")
    public String saveCamera(@ModelAttribute("camera") Camera camera) {
        cameraService.create(camera);
        return "redirect:/home";
    }
    @PostMapping("/location/add")
    public String saveLocation(@ModelAttribute("location") Location location) {
        locationService.create(location);
        return "redirect:/home";
    }

    @PostMapping("/vehicle/add")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.create(vehicle);
        return "redirect:/home";
    }
}
