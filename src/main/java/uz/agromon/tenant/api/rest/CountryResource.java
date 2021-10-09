package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.service.DistrictService;
import uz.agromon.tenant.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api/tenant")
public class CountryResource {

    @Autowired
    RegionService regionService;

    @Autowired
    DistrictService districtService;

    @GetMapping(value = "/{tenantId}/regions")
    List<Region> getAllRegionsByTenantId(@PathVariable String tenantId){
        return regionService.getAllRegionsByTenant(tenantId);
    }
    @PostMapping(value = "/regions")
    Region createRegion(@RequestBody Region region){
        return regionService.create(region);
    }

    @PostMapping(value = "/district")
    District createDistrict(@RequestBody District district) {
        return districtService.create(district);
    }
    @GetMapping(value = "/district/{tenantId}/{regionId}")
    List<District> getDistricts(@PathVariable String tenantId, @PathVariable String regionId){
        return districtService.getDistrictsOfRegion(tenantId, regionId);
    }
}
