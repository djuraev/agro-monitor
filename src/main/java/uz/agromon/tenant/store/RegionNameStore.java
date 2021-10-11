package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.RegionName;

import java.util.List;

public interface RegionNameStore {
    RegionName save(RegionName regionName);
    List<RegionName> getNamesOfRegion(Integer regionSequence);
}
