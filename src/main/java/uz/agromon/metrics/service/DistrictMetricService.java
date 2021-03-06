package uz.agromon.metrics.service;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.mobile.dto.response.YearValue;

import java.time.Year;
import java.util.List;

public interface DistrictMetricService {
    DistrictMetric save(DistrictMetric metric) throws AlreadyExistsException;
    List<DistrictMetric> save(List<DistrictMetric> metrics);
    DistrictMetric getMetricById(Integer id);
    List<DistrictMetric> getAllMetrics();
    List<DistrictMetric> getDistrictMetrics(String districtId);
    List<DistrictMetric> getDistrictMetrics(Integer districtId, String metricId);
    List<DistrictMetric> getDistrictMetrics(String districtId, String metricId, String cropId);
    List<YearValue> getDistrictMetricYearValues(Integer districtId, Integer metricId);
    List<YearValue> getDistrictMetricYearValues(Integer districtId, Integer metricId, Integer cropId);

}
