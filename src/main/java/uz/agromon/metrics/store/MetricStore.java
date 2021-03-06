package uz.agromon.metrics.store;

import uz.agromon.metrics.domain.Metric;

import java.util.List;

public interface MetricStore {
    Metric save(Metric metric);
    Metric getById(Integer id);
    List<Metric> getAllMetrics();
}
