package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.DistrictName;

import java.util.List;

public interface DistrictStore {
    District create(District district);
    District retrieve(Integer sequence);
    List<District> retrieve();
    List<District> retrieveByTenantAndRegion(Integer tenantId, Integer regionId);
    List<District> retrieveByRegion(Integer regionId);
    District addName(Integer regionSequence, DistrictName name);
}
