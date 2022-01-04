package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Village;
import uz.agromon.tenant.domain.VillageName;
import uz.agromon.tenant.store.jpo.VillageJpo;
import uz.agromon.tenant.store.jpo.VillageNameJpo;
import uz.agromon.tenant.store.repo.VillageNameRepository;
import uz.agromon.tenant.store.repo.VillageRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class VillageStoreLogic implements VillageStore {
    @Autowired
    VillageRepository repository;

    @Autowired
    VillageNameRepository villageNameRepository;


    @Override
    public Village create(Village village) {
        VillageJpo jpo = new VillageJpo(village);
        return repository.save(jpo).toDomain();
    }

    @Override
    @Transactional
    public List<Village> saveAll(List<Village> villages) {
        List<VillageJpo> jpos = Village.toJpos(villages);
        jpos = repository.saveAll(jpos);
        return VillageJpo.toDomains(jpos);
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

    @Override
    public List<Village> retrieveByDistrict(Integer districtSequence) {
        List<VillageJpo> jpos = repository.getAllByDistrictSequence(districtSequence);
        return VillageJpo.toDomains(jpos);
    }

    @Override
    public Village addName(Integer villageSequence, VillageName name) {
        VillageJpo villageJpo = repository.getById(villageSequence);
        VillageNameJpo villageNameJpo = VillageNameJpo.fromDomain(name);

        Set<String> langCodes = new HashSet<>();
        villageJpo.getNames().forEach(nameJpo -> langCodes.add(nameJpo.getLangCode()));

        if (!langCodes.contains(name.getLangCode())) {
            villageNameJpo.setVillage(villageJpo);
            villageNameRepository.save(villageNameJpo);
        }
        return villageJpo.toDomain();
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
