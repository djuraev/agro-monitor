package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.AlreadyExistsException;
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
import java.util.Collections;
import java.util.Comparator;
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
    public DistrictMetric save(DistrictMetric metric) throws AlreadyExistsException {
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
        updateMetricsInfo(metrics);
        return metrics;
    }

    @Override
    public List<DistrictMetric> getDistrictMetrics(Integer districtId, String metricId) {
        List<DistrictMetric> metrics = districtMetricStore.retrieveByDistrictAndMetric(districtId, Integer.parseInt(metricId));
        this.updateMetricsInfo(metrics);
        return metrics;
    }

    @Override
    public List<DistrictMetric> getDistrictMetrics(String districtId, String metricId, String cropId) {
        Integer did = Integer.valueOf(districtId), mid = Integer.valueOf(metricId), cid = Integer.valueOf(cropId);
        List<DistrictMetric> metrics = districtMetricStore.retrieveByDistrictAndMetricAndCrop(did, mid, cid);
        this.updateMetricsInfo(metrics);
        return metrics;
    }

    private void updateMetricsInfo(List<DistrictMetric> metrics) {
        for (DistrictMetric dm: metrics) {
            Crop crop = cropStore.retrieve(dm.getCropId());
            Metric metric = metricStore.getById(dm.getMetricId());
            dm.setCropName(crop.getName());
            dm.setMetricName(metric.getName());
        }
        Collections.sort(metrics, Comparator.comparing(DistrictMetric::getYear));
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
