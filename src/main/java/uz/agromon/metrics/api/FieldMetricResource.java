package uz.agromon.metrics.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.metrics.domain.FieldMetric;
import uz.agromon.metrics.service.FieldMetricService;

import java.util.List;

@RestController
@RequestMapping("/api/field-metric")
public class FieldMetricResource {
    //
    @Autowired
    FieldMetricService fieldMetricService;

    @PostMapping("/filed-metric")
    ResponseEntity<APIResponse> saveFieldMetric(@RequestBody FieldMetric metric) {
        FieldMetric savedData = fieldMetricService.save(metric);
        return ResponseBuilder.buildOk(savedData);
    }

    @GetMapping("/field-metrics/{fieldId}")
    ResponseEntity<APIResponse> getFieldMetrics(@PathVariable String fieldId) {
        List<FieldMetric> metrics = fieldMetricService.getFieldMetrics(fieldId);
        return ResponseBuilder.buildOk(metrics);
    }
}
