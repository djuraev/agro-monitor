package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;
import uz.agromon.tenant.domain.cdo.RegionCdo;
import uz.agromon.tenant.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api/tenant/region")
public class RegionResource {

    @Autowired
    RegionService regionService;

    @PostMapping("/region")
    Region createRegion(@RequestBody Region region) {
        return regionService.create(region);
    }

    @PostMapping("/name/{regionId}")
    Region addNameToRegion(@PathVariable Integer regionId, @RequestBody RegionName regionName) {
        return regionService.addName(regionId, regionName);
    }

    @GetMapping("/regions")
    List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/regions/{tenantCode}/{langCode}")
    List<RegionCdo> getTenantRegionsByLanguage(@PathVariable String tenantCode, @PathVariable String langCode) {
        return regionService.getRegionsOfTenant(tenantCode, langCode);
    }
    @GetMapping("/regions/{tenantCode}")
    List<Region> getTenantRegions(@PathVariable String tenantCode) {
        return regionService.getAllRegionsByTenantCode(tenantCode);
    }
}
