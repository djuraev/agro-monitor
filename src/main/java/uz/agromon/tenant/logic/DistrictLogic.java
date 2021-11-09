package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.DistrictName;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.cdo.DistrictCdo;
import uz.agromon.tenant.service.DistrictService;
import uz.agromon.tenant.service.RegionService;
import uz.agromon.tenant.store.DistrictStore;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictLogic implements DistrictService {
    @Autowired
    DistrictStore districtStore;

    @Autowired
    RegionService regionService;

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

    @Override
    public List<District> getDistrictsOfRegion(String regionSequence) {
        Integer rId = Integer.valueOf(regionSequence);
        return districtStore.retrieveByRegion(rId);
    }

    @Override
    public List<DistrictCdo> getDistrictOfRegion(String regionSequence, String langCode) {
        Integer regSequence = Integer.valueOf(regionSequence);

        List<District> districts = districtStore.retrieveByRegion(regSequence);
        List<DistrictCdo> districtCdos = new ArrayList<>();
        for (District district: districts) {
            districtCdos.add(district.toCdo(langCode));
        }
        return districtCdos;
    }

    @Override
    public District addName(String regionSequence, DistrictName name) {
        Integer rId = Integer.valueOf(regionSequence);
        return districtStore.addName(rId, name);
    }

    @Override
    public District getDistrict(Integer id) {
        return districtStore.retrieve(id);
    }
}
