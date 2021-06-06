package com.bipin.vehicle.tracker.controller;

import com.bipin.vehicle.tracker.entity.Camera;
import com.bipin.vehicle.tracker.entity.Location;
import com.bipin.vehicle.tracker.entity.Vehicle;
import com.bipin.vehicle.tracker.model.TrackerReport;
import com.bipin.vehicle.tracker.service.CameraService;
import com.bipin.vehicle.tracker.service.LocationService;
import com.bipin.vehicle.tracker.service.TrackerReportService;
import com.bipin.vehicle.tracker.service.VehicleService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private CameraService cameraService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private TrackerReportService trackerReportService;

   /*
   VEHICLE CRUD
    */

    @PostMapping(value = "/vehicles")
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle vehicle1 = vehicleService.create(vehicle);
            return new ResponseEntity<>(vehicle1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/vehicles")
    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle vehicle1 = vehicleService.update(vehicle);
            return new ResponseEntity<>(vehicle1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") Long id) {
        try {
            vehicleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getAllVehicles() {
        try {
            List<Vehicle> vehicleList = vehicleService.findAll();
            return new ResponseEntity<>(vehicleList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable("id") Long id) {
        try {
            Vehicle vehicle = vehicleService.findById(id);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /*
   LOCATION CRUD
    */

    @PostMapping(value = "/locations")
    public ResponseEntity<?> createLocations(@RequestBody Location location) {
        try {
            Location location1 = locationService.create(location);
            return new ResponseEntity<>(location1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/locations")
    public ResponseEntity<?> updateLocation(@RequestBody Location location) {
        try {
            Location location1 = locationService.update(location);
            return new ResponseEntity<>(location1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable("id") Long id) {
        try {
            locationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations")
    public ResponseEntity<?> getAllLocations() {
        try {
            List<Location> locationList = locationService.findAll();
            return new ResponseEntity<>(locationList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<?> getLocationById(@PathVariable("id") Long id) {
        try {
            Location location = locationService.findById(id);
            return new ResponseEntity<>(location, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /*
    CAMERA CRUD
    */

    @PostMapping("/cameras")
    public ResponseEntity<?> createCamera(@RequestBody Camera camera) {
        try {
            Camera camera1 = cameraService.create(camera);
            return new ResponseEntity<>(camera1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cameras")
    public ResponseEntity<?> updateCamera(@RequestBody Camera camera) {
        try {
            Camera camera1 = cameraService.update(camera);
            return new ResponseEntity<>(camera1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cameras/{id}")
    public ResponseEntity<?> deleteCamera(@PathVariable("id") Long id) {
        try {
            cameraService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cameras")
    public ResponseEntity<?> getAllCameras() {
        try {
            List<Camera> cameraList = cameraService.findAll();
            return new ResponseEntity<>(cameraList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cameras/{id}")
    public ResponseEntity<?> getCameraById(@PathVariable("id") Long id) {
        try {
            Camera camera = cameraService.findById(id);
            return new ResponseEntity<>(camera, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/report/{id}")
    public ResponseEntity<Resource> generateTrackerPdfReport(@PathVariable("id") Long id) throws IOException, DocumentException {

        List<TrackerReport> trackerReportList = trackerReportService.getTrackerReportByVid(id);

        Document document = new Document(PageSize.A4, 25, 25, 25, 25);

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, os);

        document.open();

        Paragraph title = new Paragraph("Vehicle Tracker Report",
                FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(0, 255, 255)));

        document.add(title);

        PdfPTable table = new PdfPTable(3);
        table.setSpacingBefore(25);
        table.setSpacingAfter(25);

        PdfPCell c1 = new PdfPCell(new Phrase("VEHICLE NUMBER"));
        table.addCell(c1);

        PdfPCell c2 = new PdfPCell(new Phrase("LOCATION"));
        table.addCell(c2);

        PdfPCell c3 = new PdfPCell(new Phrase("CAMERA DETAILS"));
        table.addCell(c3);


        for (TrackerReport report : trackerReportList) {
            table.addCell(report.getVehicleNumber());
            table.addCell(report.getLocation());
            table.addCell(String.valueOf(report.getCameraDetails()));
        }

        document.add(table);

        document.close();

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=TrackerPdfReport.pdf");

        ResponseEntity<Resource> response = new ResponseEntity<Resource>(new InputStreamResource(is), headers,
                HttpStatus.OK);

        return response;
    }

}

