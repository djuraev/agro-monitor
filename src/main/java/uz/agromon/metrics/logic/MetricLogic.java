package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.service.MetricService;
import uz.agromon.metrics.store.MetricStore;

import java.util.List;

@Service
public class MetricLogic implements MetricService {
    @Autowired
    MetricStore metricStore;

    @Override
    public Metric save(Metric metric) {
        return metricStore.save(metric);
    }

    @Override
    public Metric getMetricById(Integer id) {
        return metricStore.getById(id);
    }

    @Override
    public List<Metric> getAllMetrics() {
        return metricStore.getAllMetrics();
    }
}
