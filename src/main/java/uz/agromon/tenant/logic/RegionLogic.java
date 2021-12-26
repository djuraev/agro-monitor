package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.cdo.RegionCdo;
import uz.agromon.tenant.service.RegionService;
import uz.agromon.tenant.store.RegionStore;
import uz.agromon.tenant.store.TenantStore;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegionLogic implements RegionService {
    @Autowired
    RegionStore regionStore;

    @Autowired
    TenantStore tenantStore;

    @Override
    public Region create(Region region) throws AlreadyExistsException {
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

    @Override
    public List<RegionCdo> getRegionsOfTenant(String tenantCode, String langCode) {
        Tenant tenant = tenantStore.retrieve(tenantCode);
        if (tenant == null) {
            throw new ResourceNotFoundException(Tenant.class, "Tenant not found");
        }
        List<Region> regions = regionStore.retrieveByTenantId(tenant.getId());
        List<RegionCdo> cdos = new ArrayList<>();
        for (Region region: regions) {
            cdos.add(region.toCdo(langCode));
        }
        return cdos;
    }

    @Override
    public List<Region> getAllRegionsByTenantCode(String tenantCode) {
        Tenant tenant = tenantStore.retrieve(tenantCode);
        return regionStore.retrieveByTenantId(tenant.getId());
    }

    @Override
    public Region addName(Integer regionSequence, RegionName name) {
        return regionStore.addName(regionSequence, name);
    }

    @Override
    public Region retrieveRegion(Integer regionId) {
        return regionStore.retrieve(regionId);
    }
}
