package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.store.jpo.VillageJpo;
import uz.agromon.tenant.store.repo.VillageRepository;

import java.util.List;

@Repository
public class VillageStoreLogic implements VillageStore {
    @Autowired
    VillageRepository repository;

    @Override
    public Village create(Village village) {
        VillageJpo jpo = new VillageJpo(village);
        return repository.save(jpo).toDomain();
    }

    @Override
    public Village retrieve(Integer sequence) {
        VillageJpo jpo = repository.getById(sequence);
        return jpo.toDomain();
    }

    @Override
    public List<Village> retrieve() {
        List<VillageJpo> jpos = repository.findAll();
        return VillageJpo.toDomains(jpos);
    }
}
