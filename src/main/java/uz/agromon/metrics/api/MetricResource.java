package uz.agromon.metrics.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.service.MetricService;

import java.util.List;

@RestController
@RequestMapping("/api/metric")
public class MetricResource {
    @Autowired
    MetricService metricService;

    @PostMapping("/metric")
    ResponseEntity<APIResponse> createMetric(@RequestBody Metric metric) {
        Metric entity = metricService.save(metric);
        return ResponseBuilder.buildOk(entity);
    }

    @GetMapping("/metrics")
    ResponseEntity<APIResponse> getAllMetrics() {
        List<Metric> allMetrics = metricService.getAllMetrics();
        return ResponseBuilder.buildOk(allMetrics);
    }

    @GetMapping("/metric/{id}")
    ResponseEntity<APIResponse> getMetricById(@PathVariable String id) {
        Integer metricId = Integer.parseInt(id);
        Metric metric = metricService.getMetricById(metricId);
        return ResponseBuilder.buildOk(metric);
    }
}
