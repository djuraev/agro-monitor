package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.Tenant;
import java.util.List;

public interface TenantStore {
    Tenant create(Tenant tenant) ;
    Tenant retrieve(Integer id);
    Tenant retrieve(String code);
    List<Tenant> retrieveAll();
    boolean exists(String country);
    Tenant update(Tenant tenant);
    void delete(Tenant tenant);
}
