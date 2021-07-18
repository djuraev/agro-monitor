package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.Tenant;
import java.util.List;

public interface TenantStore {
    Tenant create(Tenant tenant) ;
    Tenant retrieve(Integer id);
    Tenant retrieve(String country);
    List<Tenant> retrieveAll();
    boolean exists(String country);
}
