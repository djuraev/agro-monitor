package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.metrics.domain.FieldMetric;
import uz.agromon.metrics.service.FieldMetricService;
import uz.agromon.metrics.store.FieldMetricStore;

import java.util.List;

@Service
@Deprecated
public class FieldMetricLogic implements FieldMetricService {
    @Autowired
    FieldMetricStore fieldMetricStore;

    @Override
    public FieldMetric save(FieldMetric metric) {
        return fieldMetricStore.save(metric);
    }

    @Override
    public List<FieldMetric> getFieldMetrics(String fieldId) {
        Integer id = Integer.parseInt(fieldId);
        return fieldMetricStore.getMetricsByFieldId(id);
    }
}
