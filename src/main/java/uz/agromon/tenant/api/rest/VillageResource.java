package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.service.VillageService;

import java.util.List;

@RestController
@RequestMapping("/api/tenant/village")
public class VillageResource {

    @Autowired
    VillageService villageService;

    @PostMapping("/village")
    Village createVillage(@RequestBody Village village) {
        return villageService.create(village);
    }

    @GetMapping("/villages/{districtId}/{langCode}")
    List<Village> getVillagesOfDistrict(@PathVariable String districtId, @PathVariable String langCode) {
        return null;
    }
}
