package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.service.TenantService;
import uz.agromon.tenant.store.TenantStore;


import java.util.List;

@Service
public class TenantLogic implements TenantService {
    @Autowired
    TenantStore store;

    @Override
    public Tenant create(Tenant tenant) {
        return store.create(tenant);
    }

    @Override
    public List<Tenant> getAllTenants() {
        return store.retrieveAll();
    }
}
