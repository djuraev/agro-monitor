package uz.agromon.metrics.store;

import uz.agromon.metrics.domain.VillageMetric;

import java.util.List;

public interface VillageMetricStore {
    VillageMetric save(VillageMetric metric);
    VillageMetric getById(Integer id);
    List<VillageMetric> getAll();
}
