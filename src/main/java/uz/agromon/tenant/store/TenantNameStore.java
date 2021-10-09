package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.TenantName;

import java.util.List;

public interface TenantNameStore {
    TenantName create(TenantName tenantName) throws Exception;
    List<TenantName> getAllNames();
}
