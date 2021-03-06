package uz.agromon.tenant.store;

import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;

import java.util.List;

public interface RegionStore {
    Region create(Region region) throws AlreadyExistsException;
    Region retrieve(Integer sequence);
    List<Region> retrieve();
    List<Region> retrieveByTenantId(Integer tenantId);
    List<Region> retrieveByTenantCode(String tenantCode);
    Region addName(Integer regionSequence, RegionName regionName);

}
