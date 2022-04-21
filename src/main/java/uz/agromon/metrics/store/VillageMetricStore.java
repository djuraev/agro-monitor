package uz.agromon.metrics.store;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.metrics.domain.VillageMetric;

import java.util.List;

public interface VillageMetricStore {
    VillageMetric save(VillageMetric metric) throws AlreadyExistsException;
    List<VillageMetric> saveAll(List<VillageMetric> metric);
    VillageMetric getById(Integer id);
    List<VillageMetric> getAll();
    List<VillageMetric> getVillageMetrics(Integer villageSequence);
    List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId);
    List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId, Integer cropId);
    List<VillageMetric> getAllBy(VillageMetric villageMetric);
}
