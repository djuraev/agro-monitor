package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.store.jpo.TenantJpo;
import uz.agromon.tenant.store.repo.TenantRepository;

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
    public Tenant retrieve(String country) {
        TenantJpo jpo = repository.getByCountry(country);
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
}
