package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.domain.VillageName;

import java.util.List;

public interface VillageStore {
    Village create(Village village);
    Village retrieve(Integer sequence);
    List<Village> retrieve();
    List<Village> retrieveByDistrict(Integer districtSequence);
    Village addName(Integer villageSequence, VillageName name);
}
