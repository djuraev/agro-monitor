package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;
import uz.agromon.tenant.store.jpo.RegionJpo;
import uz.agromon.tenant.store.repo.RegionRepository;
import uz.agromon.tenant.store.repo.TenantRepository;

import java.util.List;

@Repository
public class RegionStoreLogic implements RegionStore{
    @Autowired
    RegionRepository repository;

    @Autowired
    TenantRepository tenantRepository;

    @Override
    public Region create(Region region) {
        RegionJpo jpo = new RegionJpo(region);
        return repository.save(jpo).toDomain();
    }

    @Override
    public Region retrieve(Integer sequence) {
        RegionJpo jpo = repository.getById(sequence);
        return jpo.toDomain();
    }

    @Override
    public List<Region> retrieve() {
        List<RegionJpo> jpos = repository.findAll();
        return RegionJpo.toDomains(jpos);
    }

    @Override
    public List<Region> retrieveByTenantId(Integer tenantId) {
        List<RegionJpo> jpos = repository.getAllByTenantId(tenantId);
        return RegionJpo.toDomains(jpos);
    }

    @Override
    public Region addName(Integer regionSequence, RegionName regionName) {
        return null;
    }

}
