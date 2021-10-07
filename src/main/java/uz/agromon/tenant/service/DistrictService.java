package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.District;

import java.util.List;

public interface DistrictService {
    District create(District district);
    List<District> getAllDistricts();
    List<District> getDistrictsOfRegion(String tenantId, String regionId);
}
