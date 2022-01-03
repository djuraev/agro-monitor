package uz.agromon.metrics.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.service.DistrictMetricService;

import java.util.List;

@RestController
@RequestMapping("/api/district-metric")
public class DistrictMetricResource {

    @Autowired
    DistrictMetricService districtMetricService;

    @PostMapping("/metric")
    ResponseEntity<APIResponse> createDistrictMetric(@RequestBody DistrictMetric metric) {
        DistrictMetric entity = districtMetricService.save(metric);
        return ResponseBuilder.buildOk(entity);
    }

    @GetMapping("/metrics")
    ResponseEntity<APIResponse> getAllMetrics() {
        List<DistrictMetric> metrics = districtMetricService.getAllMetrics();
        return ResponseBuilder.buildOk(metrics);
    }

    @GetMapping("/metric/{id}")
    ResponseEntity<APIResponse> getMetricById(@PathVariable String id) {
        List<DistrictMetric> entity = districtMetricService.getDistrictMetrics(id);
        return ResponseBuilder.buildOk(entity);
    }
}
