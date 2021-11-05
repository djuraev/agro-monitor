package uz.agromon.metrics.store;

import uz.agromon.metrics.domain.FieldMetric;

import java.util.List;

public interface FieldMetricStore {
    List<FieldMetric> getMetricsByFieldId(Integer id);
    FieldMetric save(FieldMetric metric);
}
