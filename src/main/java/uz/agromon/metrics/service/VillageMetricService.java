package uz.agromon.metrics.service;

import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.mobile.dto.response.YearValue;

import java.util.List;

public interface VillageMetricService {
    VillageMetric save(VillageMetric villageMetric);
    List<VillageMetric> save(List<VillageMetric> villageMetrics);
    VillageMetric getMetricById(Integer id);
    List<VillageMetric> getAllMetrics();
    List<VillageMetric> getVillageMetrics(String villageSequence);
    List<VillageMetric> getVillageMetrics(Integer villageSequence);
    List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId);
    List<YearValue> getVillageMetricsYearValues(Integer villageId, Integer metricId);
    List<YearValue> getVillageMetricsYearValues(Integer villageId, Integer metricId, Integer cropId);
}
