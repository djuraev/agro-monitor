package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.service.VillageService;
import uz.agromon.tenant.store.VillageStore;

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
}
