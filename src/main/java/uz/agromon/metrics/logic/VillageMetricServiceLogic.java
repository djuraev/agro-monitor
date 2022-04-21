package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.metrics.service.VillageMetricService;
import uz.agromon.metrics.store.CropStore;
import uz.agromon.metrics.store.MetricStore;
import uz.agromon.metrics.store.VillageMetricStore;
import uz.agromon.mobile.dto.response.YearValue;

import java.util.ArrayList;
import java.util.List;

@Service
public class VillageMetricServiceLogic implements VillageMetricService {
    @Autowired
    VillageMetricStore villageMetricStore;

    @Autowired
    CropStore cropStore;

    @Autowired
    MetricStore metricStore;

    @Override
    public VillageMetric save(VillageMetric village) throws AlreadyExistsException {
        return villageMetricStore.save(village);
    }

    @Override
    public List<VillageMetric> save(List<VillageMetric> villageMetrics) {
        return villageMetricStore.saveAll(villageMetrics);
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
        List<VillageMetric> villageMetrics = villageMetricStore.getVillageMetrics(sequence);
        this.updateMetricAndCropDate(villageMetrics);
        return villageMetrics;
    }

    @Override
    public List<VillageMetric> getVillageMetrics(Integer villageSequence) {
        return villageMetricStore.getVillageMetrics(villageSequence);
    }

    @Override
    public List<VillageMetric> getVillageMetrics(Integer villageId, Integer metricId) {
        return villageMetricStore.getVillageMetrics(villageId, metricId);
    }

    @Override
    public List<YearValue> getVillageMetricsYearValues(Integer villageId, Integer metricId) {
        List<VillageMetric> villageMetrics = villageMetricStore.getVillageMetrics(villageId, metricId);
        List<YearValue> yearValues = new ArrayList<>();
        for (VillageMetric vm: villageMetrics) {
            yearValues.add(new YearValue(vm.getYear(), vm.getValue()));
        }
        return yearValues;
    }

    @Override
    public List<YearValue> getVillageMetricsYearValues(Integer villageId, Integer metricId, Integer cropId) {
        List<VillageMetric> villageMetrics = villageMetricStore.getVillageMetrics(villageId, metricId, cropId);
        List<YearValue> yearValues = new ArrayList<>();
        for (VillageMetric vm: villageMetrics) {
            yearValues.add(new YearValue(vm.getYear(), vm.getValue()));
        }
        return yearValues;
    }

    @Override
    public List<VillageMetric> getAllBy(VillageMetric villageMetric) {
        List<VillageMetric> villageMetrics = villageMetricStore.getAllBy(villageMetric);
        this.updateMetricAndCropDate(villageMetrics);
        return villageMetrics;
    }

    private void updateMetricAndCropDate(List<VillageMetric> metrics) {
        for (VillageMetric vm: metrics) {
            Crop crop = cropStore.retrieve(vm.getCropId());
            Metric metric = metricStore.getById(vm.getMetricId());
            vm.setMetricName(metric.getName());
            vm.setCropName(crop.getName());
        }
    }
}
