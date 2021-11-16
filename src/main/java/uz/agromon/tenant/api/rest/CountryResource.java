package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
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
    ResponseEntity<APIResponse> getAllRegionsByTenantId(@PathVariable String tenantId){
        List<Region> regions = regionService.getAllRegionsByTenant(tenantId);
        return ResponseBuilder.buildOk(regions);
    }
    @PostMapping(value = "/regions")
    ResponseEntity<APIResponse> createRegion(@RequestBody Region region){
        Region savedRegion = regionService.create(region);
        return ResponseBuilder.buildOk(savedRegion);
    }

    @PostMapping(value = "/district")
    ResponseEntity<APIResponse> createDistrict(@RequestBody District district) {
        District savedDistrict = districtService.create(district);
        return ResponseBuilder.buildOk(savedDistrict);
    }
    @GetMapping(value = "/district/{tenantId}/{regionId}")
    ResponseEntity<APIResponse> getDistricts(@PathVariable String tenantId, @PathVariable String regionId){
        List<District> districts = districtService.getDistrictsOfRegion(tenantId, regionId);
        return ResponseBuilder.buildOk(districts);
    }
}
