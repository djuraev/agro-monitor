package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.store.jpo.RegionJpo;
import uz.agromon.tenant.store.repo.RegionRepository;

import java.util.List;

@Repository
public class RegionStoreLogic implements RegionStore{
    @Autowired
    RegionRepository repository;

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
}
