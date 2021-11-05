package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.metrics.service.VillageMetricService;
import uz.agromon.metrics.store.VillageMetricStore;

import java.util.List;

@Service
public class VillageMetricServiceLogic implements VillageMetricService {
    @Autowired
    VillageMetricStore villageMetricStore;

    @Override
    public VillageMetric save(VillageMetric village) {
        return villageMetricStore.save(village);
    }

    @Override
    public VillageMetric getMetricById(Integer id) {
        return villageMetricStore.getById(id);
    }

    @Override
    public List<VillageMetric> getAllMetrics() {
        return villageMetricStore.getAll();
    }

    @Override
    public List<VillageMetric> getVillageMetrics(String villageSequence) {
        Integer sequence = Integer.parseInt(villageSequence);
        return villageMetricStore.getVillageMetrics(sequence);
    }
}
