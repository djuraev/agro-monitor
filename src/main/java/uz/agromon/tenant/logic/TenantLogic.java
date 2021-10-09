package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.TenantName;
import uz.agromon.tenant.service.TenantService;
import uz.agromon.tenant.store.TenantNameStore;
import uz.agromon.tenant.store.TenantStore;
import uz.agromon.tenant.store.jpo.TenantJpo;


import java.util.List;

@Service
public class TenantLogic implements TenantService {
    @Autowired
    TenantStore tenantStore;

    @Autowired
    TenantNameStore tenantNameStore;
    @Override
    public Tenant create(Tenant tenant) {
        return tenantStore.create(tenant);
    }

    @Override
    public List<Tenant> getAllTenants() {
        return tenantStore.retrieveAll();
    }

    @Override
    public Tenant update(Tenant tenant) {
        return tenantStore.update(tenant);
    }

    @Override
    public Tenant update(String tenantCode, TenantName tenantName) {
        return tenantStore.addName(tenantCode, tenantName);
    }

    @Override
    public void delete(Tenant tenant) {
        tenantStore.delete(tenant);
    }

    @Override
    public Tenant retrieve(String tenantCode) {
        return tenantStore.retrieve(tenantCode);
    }
}
