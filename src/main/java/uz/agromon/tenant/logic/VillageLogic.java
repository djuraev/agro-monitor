package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.domain.VillageName;
import uz.agromon.tenant.domain.cdo.VillageCdo;
import uz.agromon.tenant.service.VillageService;
import uz.agromon.tenant.store.VillageStore;
import java.util.ArrayList;
import java.util.List;

@Service
public class VillageLogic implements VillageService {
    @Autowired
    VillageStore villageStore;

    @Override
    public Village create(Village village) {
        return villageStore.create(village);
    }

    @Override
    public List<Village> getAllVillages() {
        return villageStore.retrieve();
    }

    @Override
    public List<Village> getVillagesOfDistrict(String districtSequence) {
        Integer dId = Integer.valueOf(districtSequence);
        return villageStore.retrieveByDistrict(dId);
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
