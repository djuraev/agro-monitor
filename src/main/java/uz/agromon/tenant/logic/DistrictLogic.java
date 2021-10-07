package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.service.DistrictService;
import uz.agromon.tenant.store.DistrictStore;

import java.util.List;

@Service
public class DistrictLogic implements DistrictService {
    @Autowired
    DistrictStore districtStore;

    @Override
    public District create(District district) {
        return districtStore.create(district);
    }

    @Override
    public List<District> getAllDistricts() {
        return districtStore.retrieve();
    }

    @Override
    public List<District> getDistrictsOfRegion(String tenantId, String regionId) {
        Integer tId = Integer.valueOf(tenantId);
        Integer dId = Integer.valueOf(regionId);
        return districtStore.retrieveByTenantAndRegion(tId, dId);
    }
}
