package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.TenantName;

import java.util.List;

public interface TenantService {
    Tenant create(Tenant tenant);
    List<Tenant> getAllTenants();
    Tenant update(Tenant tenant);
    Tenant update(String tenantCode, TenantName tenantName);
    void delete(Tenant tenant);
    Tenant retrieve(String tenantCode);
}
