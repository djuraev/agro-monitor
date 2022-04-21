package uz.agromon.metrics.store;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.metrics.domain.DistrictMetric;

import java.util.List;

public interface DistrictMetricStore {
    DistrictMetric save(DistrictMetric metric) throws AlreadyExistsException;
    List<DistrictMetric> save(List<DistrictMetric> metrics);
    DistrictMetric getById(Integer id);
    List<DistrictMetric> retrieveAll();
    List<DistrictMetric> retrieveByDistrictId(Integer districtId);
    List<DistrictMetric> retrieveByDistrictAndMetric(Integer districtId, Integer metricId);
    List<DistrictMetric> retrieveByDistrictAndMetricAndCrop(Integer districtId, Integer metricId, Integer cropId);
}
