package com.bipin.vehicle.tracker.service.impl;

import com.bipin.vehicle.tracker.model.TrackerReport;
import com.bipin.vehicle.tracker.service.TrackerReportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackerReportServiceImpl implements TrackerReportService {

    @Override
    public List<TrackerReport> getTrackerReportByVid(Long id) {
        List<TrackerReport> trackerReportList = new ArrayList<>();
        trackerReportList.add(new TrackerReport("BA 21 PA 1234", "Chabahil, Kathmandu", "CAMX12"));
        trackerReportList.add(new TrackerReport("BA 21 PA 1234", "Sukedhara, Kathmandu", "CAMX34"));
        trackerReportList.add(new TrackerReport("BA 21 PA 1234", "Maharajgunj, Kathmandu", "CAMX56"));
        trackerReportList.add(new TrackerReport("BA 21 PA 1234", "Baluwatar, Kathmandu", "CAMX67"));
        return trackerReportList;
    }
}
