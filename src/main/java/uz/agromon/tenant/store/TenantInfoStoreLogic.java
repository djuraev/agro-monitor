package uz.agromon.tenant.store;

import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.TenantInfo;

import java.util.List;

@Repository
public class TenantInfoStoreLogic implements TenantInfoStore{
    @Override
    public TenantInfo create(TenantInfo info) {
        return null;
    }

    @Override
    public TenantInfo retrieve(Integer id) {
        return null;
    }

    @Override
    public List<TenantInfo> retrieveAll(Integer id) {
        return null;
    }
}
