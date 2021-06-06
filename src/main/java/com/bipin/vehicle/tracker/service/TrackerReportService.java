package com.bipin.vehicle.tracker.service;

import com.bipin.vehicle.tracker.model.TrackerReport;

import java.util.List;

public interface TrackerReportService {

    List<TrackerReport> getTrackerReportByVid(Long id);
}
