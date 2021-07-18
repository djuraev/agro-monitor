package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.Tenant;

import java.util.List;

public interface TenantService {
    Tenant create(Tenant tenant);
    List<Tenant> getAllTenants();
}
