package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.District;
import java.util.List;

public interface DistrictStore {
    District create(District district);
    District retrieve(Integer sequence);
    List<District> retrieve();
}
