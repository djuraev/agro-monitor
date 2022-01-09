package uz.agromon.metrics.store;

import uz.agromon.metrics.domain.VillageMetric;

import java.util.List;

public interface VillageMetricStore {
    VillageMetric save(VillageMetric metric);
    List<VillageMetric> saveAll(List<VillageMetric> metric);
    VillageMetric getById(Integer id);
    List<VillageMetric> getAll();
    List<VillageMetric> getVillageMetrics(Integer villageSequence);
    List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId);
    List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId, Integer cropId);
}
