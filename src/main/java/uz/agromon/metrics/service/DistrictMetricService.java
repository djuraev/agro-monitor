package uz.agromon.metrics.service;

import uz.agromon.metrics.domain.DistrictMetric;

import java.util.List;

public interface DistrictMetricService {
    DistrictMetric save(DistrictMetric metric);
    DistrictMetric getMetricById(Integer id);
    List<DistrictMetric> getAllMetrics();
}
