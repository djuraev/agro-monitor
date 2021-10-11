package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;

import java.util.List;

public interface RegionStore {
    Region create(Region region);
    Region retrieve(Integer sequence);
    List<Region> retrieve();
    List<Region> retrieveByTenantId(Integer tenantId);
    Region addName(Integer regionSequence, RegionName regionName);

}
