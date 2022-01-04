package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.domain.VillageName;
import uz.agromon.tenant.domain.cdo.VillageCdo;

import java.util.List;

public interface VillageService {
    Village create(Village village);
    List<Village> create(List<Village> villages);
    List<Village> getAllVillages();
    List<Village> getVillagesOfDistrict(String districtSequence);
    List<VillageCdo> getVillagesOfDistrict(String districtSequence, String langCode);
    Village addName(String districtSequence, VillageName villageName);
    Village getVillage(Integer id);
}
