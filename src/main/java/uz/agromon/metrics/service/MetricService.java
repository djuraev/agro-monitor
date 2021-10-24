package uz.agromon.metrics.service;

import uz.agromon.metrics.domain.Metric;

import java.util.List;

public interface MetricService {
    Metric save(Metric metric);
    Metric getMetricById(Integer id);
    List<Metric> getAllMetrics();
}
