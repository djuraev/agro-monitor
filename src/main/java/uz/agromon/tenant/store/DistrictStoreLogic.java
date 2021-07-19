package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.store.jpo.DistrictJpo;
import uz.agromon.tenant.store.jpo.RegionJpo;
import uz.agromon.tenant.store.repo.DistrictRepository;

import java.util.List;

@Repository
public class DistrictStoreLogic implements DistrictStore {
    @Autowired
    DistrictRepository repository;

    @Override
    public District create(District district) {
        DistrictJpo jpo = new DistrictJpo(district);
        return repository.save(jpo).toDomain();
    }

    @Override
    public District retrieve(Integer sequence) {
        DistrictJpo jpo = repository.getById(sequence);
        return jpo.toDomain();
    }

    @Override
    public List<District> retrieve() {
        List<DistrictJpo> jpos = repository.findAll();
        return DistrictJpo.toDomains(jpos);
    }
}
