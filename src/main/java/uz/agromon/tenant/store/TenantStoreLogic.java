package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.TenantName;
import uz.agromon.tenant.store.jpo.TenantJpo;
import uz.agromon.tenant.store.jpo.TenantNameJpo;
import uz.agromon.tenant.store.repo.TenantNameRepository;
import uz.agromon.tenant.store.repo.TenantRepository;


import java.util.List;

@Repository
public class TenantStoreLogic implements TenantStore{
    @Autowired
    TenantRepository tenantRepository;

    @Autowired
    TenantNameRepository tenantNameRepository;

    @Override
    public Tenant create(Tenant tenant) {
        TenantJpo jpo = new TenantJpo(tenant);
        return tenantRepository.save(jpo).toDomain();
    }

    @Override
    public Tenant retrieve(Integer id) {
        TenantJpo jpo = tenantRepository.getById(id);
        return jpo.toDomain();
    }

    @Override
    public Tenant retrieve(String code) {
        TenantJpo jpo = tenantRepository.getByCode(code);
        if (jpo == null) {
            return null;
        }
        return jpo.toDomain();
    }

    @Override
    public List<Tenant> retrieveAll() {
        List<TenantJpo> jpos = tenantRepository.findAll();
        return TenantJpo.toDomains(jpos);
    }

    @Override
    public boolean exists(String country) {
        return tenantRepository.existsByCountry(country);
    }

    @Override
    @Deprecated
    public Tenant update(Tenant tenant) {
       return null;
    }

    @Override
    public void delete(Tenant tenant) {
        TenantJpo jpo = tenantRepository.getByCode(tenant.getCode());
        tenantRepository.delete(jpo);
    }

    @Override
    public Tenant addName(String tenantCode, TenantName name) {
        TenantJpo jpo = tenantRepository.getByCode(tenantCode);
        TenantNameJpo nameJpo = TenantNameJpo.fromDomain(name);
        nameJpo.setTenantCode(jpo.getCode());
        jpo.getNames().add(nameJpo);
        jpo = tenantRepository.save(jpo);
        return jpo.toDomain();
    }
}
