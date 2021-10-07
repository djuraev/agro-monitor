package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.Region;

import java.util.List;

public interface RegionService {
    Region create(Region region);
    List<Region> getAllRegions();
    List<Region> getAllRegionsByTenant(String tenantId);
}
