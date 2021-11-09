package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.DistrictName;
import uz.agromon.tenant.domain.cdo.DistrictCdo;

import java.util.List;

public interface DistrictService {
    District create(District district);
    List<District> getAllDistricts();
    List<District> getDistrictsOfRegion(String tenantId, String regionId);
    List<District> getDistrictsOfRegion(String regionSequence);
    List<DistrictCdo> getDistrictOfRegion(String regionSequence, String langCode);
    District addName(String regionSequence, DistrictName name);
    District getDistrict(Integer id);
}
