package uz.agromon.mobile.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.metrics.service.DistrictMetricService;
import uz.agromon.metrics.service.VillageMetricService;
import uz.agromon.mobile.dto.response.MetricResponse;
import uz.agromon.mobile.service.MMetricService;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.service.DistrictService;
import uz.agromon.tenant.service.VillageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MMMetricLogic implements MMetricService {

    @Autowired
    VillageMetricService villageMetricService;
    @Autowired
    DistrictMetricService districtMetricService;
    @Autowired
    FieldService fieldService;
    @Autowired
    DistrictService districtService;
    @Autowired
    VillageService villageService;

    @Override
    public List<MetricResponse> getMetricsForField(String fieldId, String metricId) {
        List<MetricResponse> metricResponseList = new ArrayList<>();
        Integer fid = Integer.parseInt(fieldId);
        Field field = fieldService.getField(fid);

        List<VillageMetric> fieldMetrics = villageMetricService.getVillageMetrics(field.getVillageSequence().toString());
        if (fieldMetrics != null && !fieldMetrics.isEmpty()) {
            for(VillageMetric fieldMetric: fieldMetrics) {
                metricResponseList.add(new MetricResponse(fieldMetric));
            }
            return metricResponseList;
        }
        Village village = villageService.getVillage(field.getVillageSequence());
        District district = districtService.getDistrict(village.getDistrictSequence());
        List<DistrictMetric> districtMetrics = districtMetricService.getDistrictMetrics(district.getSequence().toString());
        for (DistrictMetric districtMetric: districtMetrics) {
            metricResponseList.add(new MetricResponse(districtMetric));
        }
        return metricResponseList;
    }

}
