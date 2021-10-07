package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.service.RegionService;
import uz.agromon.tenant.store.RegionStore;

import java.util.List;

@Service
public class RegionLogic implements RegionService {
    @Autowired
    RegionStore regionStore;

    @Override
    public Region create(Region region) {
        return regionStore.create(region);
    }

    @Override
    public List<Region> getAllRegions() {
        return regionStore.retrieve();
    }

    @Override
    public List<Region> getAllRegionsByTenant(String tenantId) {
        Integer id = Integer.valueOf(tenantId);
        return regionStore.retrieveByTenantId(id);
    }
}
