package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.service.DistrictMetricService;
import uz.agromon.metrics.service.MetricService;
import uz.agromon.metrics.store.CropStore;
import uz.agromon.metrics.store.DistrictMetricStore;
import uz.agromon.metrics.store.MetricStore;
import uz.agromon.mobile.dto.response.YearValue;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictMetricLogic implements DistrictMetricService {
    @Autowired
    DistrictMetricStore districtMetricStore;

    @Autowired
    MetricStore metricStore;

    @Autowired
    CropStore cropStore;


    @Override
    public DistrictMetric save(DistrictMetric metric) {
        return districtMetricStore.save(metric);
    }

    @Override
    public List<DistrictMetric> save(List<DistrictMetric> metrics) {
        return districtMetricStore.save(metrics);
    }

    @Override
    public DistrictMetric getMetricById(Integer id) {
        return districtMetricStore.getById(id);
    }

    @Override
    public List<DistrictMetric> getAllMetrics() {
        return districtMetricStore.retrieveAll();
    }

    @Override
    public List<DistrictMetric> getDistrictMetrics(String districtId) {
        Integer did = Integer.parseInt(districtId);
        List<DistrictMetric> metrics = districtMetricStore.retrieveByDistrictId(did);
        for (DistrictMetric dm: metrics) {
            Crop crop = cropStore.retrieve(dm.getCropId());
            Metric metric = metricStore.getById(dm.getMetricId());
            dm.setCropName(crop.getName());
            dm.setMetricName(metric.getName());
        }
        return metrics;
    }

    @Override
    public List<DistrictMetric> getDistrictMetrics(Integer districtId, String metricId) {
        return districtMetricStore.retrieveByDistrictAndMetric(districtId, Integer.parseInt(metricId));
    }

    @Override
    public List<YearValue> getDistrictMetricYearValues(Integer districtId, Integer metricId) {
        List<YearValue> dmValues = new ArrayList<>();
        List<DistrictMetric> districtMetrics = districtMetricStore.retrieveByDistrictAndMetric(districtId, metricId);
        for (DistrictMetric dm: districtMetrics) {
            dmValues.add(new YearValue(dm.getYear(), dm.getValue()));
        }
        return dmValues;
    }

    @Override
    public List<YearValue> getDistrictMetricYearValues(Integer districtId, Integer metricId, Integer cropId) {
        List<YearValue> dmValues = new ArrayList<>();
        List<DistrictMetric> districtMetrics = districtMetricStore.retrieveByDistrictAndMetricAndCrop(districtId, metricId, cropId);
        for (DistrictMetric dm: districtMetrics) {
            dmValues.add(new YearValue(dm.getYear(), dm.getValue()));
        }
        return dmValues;
    }
}
