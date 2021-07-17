package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.TenantInfo;

import java.util.List;

public interface TenantInfoStore {
    TenantInfo create(TenantInfo info);
    TenantInfo retrieve(Integer id);
    List<TenantInfo> retrieveAll(Integer id);
}
