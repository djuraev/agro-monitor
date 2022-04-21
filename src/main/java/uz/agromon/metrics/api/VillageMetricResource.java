package uz.agromon.metrics.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.metrics.service.VillageMetricService;

import java.util.List;

@RestController
@RequestMapping("/api/village-metric")
public class VillageMetricResource {
    @Autowired
    VillageMetricService metricService;

    @PostMapping("/metric")
    ResponseEntity<APIResponse> createMetric(@RequestBody VillageMetric metric) throws AlreadyExistsException {
        VillageMetric entity = metricService.save(metric);
        return ResponseBuilder.buildOk(entity);
    }

    @GetMapping("/metrics")
    ResponseEntity<APIResponse> getAllMetrics() {
        List<VillageMetric> metrics = metricService.getAllMetrics();
        return ResponseBuilder.buildOk(metrics);
    }

    @GetMapping("/village/{villageSequence}")
    ResponseEntity<APIResponse> getVillageMetrics(@PathVariable String villageSequence) {
        List<VillageMetric> villageMetrics = metricService.getVillageMetrics(villageSequence);
        return ResponseBuilder.buildOk(villageMetrics);
    }

    @PostMapping("/metrics")
    ResponseEntity<APIResponse> createMetrics(@RequestBody List<VillageMetric> villageMetrics) {
        villageMetrics = metricService.save(villageMetrics);
        return ResponseBuilder.buildOk(villageMetrics);
    }

    @PostMapping("/dynamic")
    ResponseEntity<APIResponse> executeDynamicQuery(@RequestBody VillageMetric villageMetric) {
        List<VillageMetric> villageMetrics = metricService.getAllBy(villageMetric);
        return ResponseBuilder.buildOk(villageMetrics);
    }
}
