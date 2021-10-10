package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;
import uz.agromon.tenant.domain.cdo.RegionCdo;

import java.util.List;

public interface RegionService {
    Region create(Region region);
    List<Region> getAllRegions();
    List<Region> getAllRegionsByTenant(String tenantId);
    List<RegionCdo> getRegionsOfTenant(String tenantCode, String langCode);
    List<Region> getAllRegionsByTenantCode(String tenantCode);
    Region addName(Integer regionId, RegionName name);
}
