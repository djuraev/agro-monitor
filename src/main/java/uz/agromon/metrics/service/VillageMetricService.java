package uz.agromon.metrics.service;

import uz.agromon.metrics.domain.VillageMetric;

import java.util.List;

public interface VillageMetricService {
    VillageMetric save(VillageMetric village);
    VillageMetric getMetricById(Integer id);
    List<VillageMetric> getAllMetrics();
}
