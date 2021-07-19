package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.Village;

import java.util.List;

public interface VillageStore {
    Village create(Village village);
    Village retrieve(Integer sequence);
    List<Village> retrieve();
}
