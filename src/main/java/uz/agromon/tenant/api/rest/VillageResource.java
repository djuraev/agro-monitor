package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.domain.VillageName;
import uz.agromon.tenant.domain.cdo.VillageCdo;
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
    List<VillageCdo> getVillagesOfDistrict(@PathVariable String districtId, @PathVariable String langCode) {
        return villageService.getVillagesOfDistrict(districtId, langCode);
    }

    @GetMapping(value = "/village/{districtCode}")
    List<Village> getRegionDistricts(@PathVariable String districtCode) {
        return villageService.getVillagesOfDistrict(districtCode);
    }

    @PostMapping(value = "/village/{villageSequence}")
    Village addName(@PathVariable String villageSequence, @RequestBody VillageName villageName) {
        return villageService.addName(villageSequence, villageName);
    }
}
