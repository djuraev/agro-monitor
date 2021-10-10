package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.cdo.RegionCdo;
import uz.agromon.tenant.service.RegionService;
import uz.agromon.tenant.store.RegionStore;
import uz.agromon.tenant.store.TenantStore;
import uz.agromon.tenant.store.jpo.TenantJpo;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionLogic implements RegionService {
    @Autowired
    RegionStore regionStore;

    @Autowired
    TenantStore tenantStore;

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

    @Override
    public List<RegionCdo> getRegionsOfTenant(String tenantCode, String langCode) {
        Tenant tenant = tenantStore.retrieve(tenantCode);
        //@FIXME - Null Pointer Exception
        if (tenant == null) {
            return null;
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
        Region region = regionStore.retrieve(regionSequence);
        //@FIXME
        if (region == null) {
            return null;
        }
        return null;
    }
}
