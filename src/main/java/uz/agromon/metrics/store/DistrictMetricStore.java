package uz.agromon.metrics.store;

import uz.agromon.metrics.domain.DistrictMetric;

import java.util.List;

public interface DistrictMetricStore {
    DistrictMetric save(DistrictMetric metric);
    DistrictMetric getById(Integer id);
    List<DistrictMetric> retrieveAll();
}
