package uz.agromon.metrics.service;

import uz.agromon.metrics.domain.FieldMetric;

import java.util.List;

@Deprecated
public interface FieldMetricService {
    FieldMetric save(FieldMetric metric);
    List<FieldMetric> getFieldMetrics(String fieldId);
}
