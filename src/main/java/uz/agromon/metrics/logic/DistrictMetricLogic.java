package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.service.DistrictMetricService;
import uz.agromon.metrics.store.DistrictMetricStore;
import uz.agromon.mobile.dto.response.YearValue;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictMetricLogic implements DistrictMetricService {
    @Autowired
    DistrictMetricStore districtMetricStore;

    @Override
    public DistrictMetric save(DistrictMetric metric) {
        return districtMetricStore.save(metric);
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
        return districtMetricStore.retrieveByDistrictId(did);
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
}
