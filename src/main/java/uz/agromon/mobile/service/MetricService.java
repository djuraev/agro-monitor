package uz.agromon.mobile.service;

import uz.agromon.mobile.dto.response.MetricResponse;

import java.util.List;

public interface MetricService {
    List<MetricResponse> getMetricsForField(String fieldId, String metricId);
}
