package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.DistrictName;
import uz.agromon.tenant.store.jpo.DistrictJpo;
import uz.agromon.tenant.store.jpo.DistrictNameJpo;
import uz.agromon.tenant.store.jpo.RegionJpo;
import uz.agromon.tenant.store.repo.DistrictNameRepository;
import uz.agromon.tenant.store.repo.DistrictRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class DistrictStoreLogic implements DistrictStore {
    @Autowired
    DistrictRepository repository;

    @Autowired
    DistrictNameRepository districtNameRepository;

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

    @Override
    public List<District> retrieveByTenantAndRegion(Integer tenantId, Integer regionId) {
        List<DistrictJpo> jpos = repository.getAllByTenantIdAndRegionSequence(tenantId, regionId);
        return DistrictJpo.toDomains(jpos);
    }

    @Override
    public List<District> retrieveByRegion(Integer regionId) {
        List<DistrictJpo> jpos = repository.getAllByRegionSequence(regionId);
        return DistrictJpo.toDomains(jpos);
    }

    @Override
    public District addName(Integer regionSequence, DistrictName name) {
        DistrictJpo districtJpo = repository.getById(regionSequence);
        DistrictNameJpo districtNameJpo = DistrictNameJpo.fromDomain(name);

        Set<String> langCodes = new HashSet<>();
        districtJpo.getNames().forEach(dName->langCodes.add(dName.getLangCode()));
        if (!langCodes.contains(name.getLangCode())) {
            districtNameJpo.setDistrict(districtJpo);
            districtNameRepository.save(districtNameJpo);
        }
        return districtJpo.toDomain();
    }
}
