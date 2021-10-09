package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.TenantName;
import uz.agromon.tenant.store.jpo.TenantJpo;
import uz.agromon.tenant.store.jpo.TenantNameJpo;
import uz.agromon.tenant.store.repo.TenantRepository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class TenantStoreLogic implements TenantStore{
    @Autowired
    TenantRepository repository;

    @Override
    public Tenant create(Tenant tenant) {
        TenantJpo jpo = new TenantJpo(tenant);
        return repository.save(jpo).toDomain();
    }

    @Override
    public Tenant retrieve(Integer id) {
        TenantJpo jpo = repository.getById(id);
        return jpo.toDomain();
    }

    @Override
    public Tenant retrieve(String code) {
        TenantJpo jpo = repository.getByCode(code);
        if (jpo == null) {
            return null;
        }
        return jpo.toDomain();
    }

    @Override
    public List<Tenant> retrieveAll() {
        List<TenantJpo> jpos = repository.findAll();
        return TenantJpo.toDomains(jpos);
    }

    @Override
    public boolean exists(String country) {
        return repository.existsByCountry(country);
    }

    @Override
    @Deprecated
    public Tenant update(Tenant tenant) {
        TenantJpo jpo = repository.getByCode(tenant.getCode());
        //@FIXME
        if (jpo == null) {
            return tenant;
        }
        List<TenantNameJpo> names = new ArrayList<>();
        for(TenantName name: tenant.getNames()) {
            TenantNameJpo tnJpo = TenantNameJpo.fromDomain(name);
            names.add(tnJpo);
        }
        jpo.setNames(names);
        return repository.save(jpo).toDomain();
    }

    @Override
    public void delete(Tenant tenant) {
        TenantJpo jpo = repository.getByCode(tenant.getCode());
        repository.delete(jpo);
    }
}
