package uz.agromon.metrics.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.service.CropService;

import java.util.List;

@RestController
@RequestMapping("/api/crop")
public class CropResource {
    @Autowired
    CropService cropService;

    @PostMapping("/crop")
    ResponseEntity<APIResponse> createCrop(@RequestBody Crop crop) {
        Crop entity = cropService.save(crop);
        return ResponseBuilder.buildOk(entity);
    }

    @GetMapping("/crops")
    ResponseEntity<APIResponse> getAllCrops() {
        List<Crop> cropList = cropService.getAllCrops();
        return ResponseBuilder.buildOk(cropList);
    }

    @GetMapping("/crop/{cropId}")
    ResponseEntity<APIResponse> getCrop(@PathVariable String cropId) {
        Integer id = Integer.parseInt(cropId);
        Crop crop = cropService.getCropById(id);
        return ResponseBuilder.buildOk(crop);
    }
}
