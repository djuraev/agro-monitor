package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.Village;

import java.util.List;

public interface VillageService {
    Village create(Village village);
    List<Village> getAllVillages();
}
