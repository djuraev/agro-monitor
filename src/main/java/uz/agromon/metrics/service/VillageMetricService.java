package uz.agromon.metrics.service;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.mobile.dto.response.YearValue;

import java.util.List;

public interface VillageMetricService {
    VillageMetric save(VillageMetric villageMetric) throws AlreadyExistsException;
    List<VillageMetric> save(List<VillageMetric> villageMetrics);
    VillageMetric getMetricById(Integer id);
    List<VillageMetric> getAllMetrics();
    List<VillageMetric> getVillageMetrics(String villageSequence);
    List<VillageMetric> getVillageMetrics(Integer villageSequence);
    List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId);
    List<YearValue> getVillageMetricsYearValues(Integer villageId, Integer metricId);
    List<YearValue> getVillageMetricsYearValues(Integer villageId, Integer metricId, Integer cropId);
    List<VillageMetric> getAllBy(VillageMetric villageMetric);
    List<VillageMetric> getAllBy(String villageId, String metricId, String cropId);
}
