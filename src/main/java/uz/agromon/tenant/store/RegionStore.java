package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.Region;

import java.util.List;

public interface RegionStore {
    Region create(Region region);
    Region retrieve(Integer sequence);
    List<Region> retrieve();
}
