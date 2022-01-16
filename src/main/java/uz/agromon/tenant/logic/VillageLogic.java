package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.*;
import uz.agromon.tenant.domain.cdo.VillageCdo;
import uz.agromon.tenant.service.VillageService;
import uz.agromon.tenant.store.DistrictStore;
import uz.agromon.tenant.store.RegionStore;
import uz.agromon.tenant.store.TenantStore;
import uz.agromon.tenant.store.VillageStore;
import java.util.ArrayList;
import java.util.List;

@Service
public class VillageLogic implements VillageService {
    @Autowired
    VillageStore villageStore;

    @Autowired
    TenantStore tenantStore;

    @Autowired
    RegionStore regionStore;

    @Autowired
    DistrictStore districtStore;

    @Override
    public Village create(Village village) {
        return villageStore.create(village);
    }

    @Override
    public List<Village> create(List<Village> villages) {
        return villageStore.saveAll(villages);
    }

    @Override
    public List<Village> getAllVillages() {
        return villageStore.retrieve();
    }

    @Override
    public List<Village> getVillagesOfDistrict(String districtSequence) {
        Integer dId = Integer.valueOf(districtSequence);
        District district = districtStore.retrieve(dId);
        Region region = regionStore.retrieve(district.getRegionSequence());
        Tenant tenant = tenantStore.retrieve(region.getTenantId());
        List<Village> villages = villageStore.retrieveByDistrict(dId);
        for (Village village: villages) {
            village.setCountry(tenant.getCountry());
            village.setRegionName(region.getName());
            village.setDistrictName(district.getName());
        }
        return villages;
    }

    @Override
    public List<VillageCdo> getVillagesOfDistrict(String districtSequence, String langCode) {
        List<Village> villages = this.getVillagesOfDistrict(districtSequence);
        List<VillageCdo> cdos = new ArrayList<>();
        villages.forEach(village -> cdos.add(village.toCdo(langCode)));
        return cdos;
    }

    @Override
    public Village addName(String districtSequence, VillageName villageName) {
        Integer dId = Integer.valueOf(districtSequence);
        return villageStore.addName(dId, villageName);
    }

    @Override
    public Village getVillage(Integer id) {
        return villageStore.retrieve(id);
    }
}
