package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.RegionName;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.store.jpo.RegionJpo;
import uz.agromon.tenant.store.jpo.RegionNameJpo;
import uz.agromon.tenant.store.jpo.TenantJpo;
import uz.agromon.tenant.store.repo.RegionNameRepository;
import uz.agromon.tenant.store.repo.RegionRepository;
import uz.agromon.tenant.store.repo.TenantRepository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RegionStoreLogic implements RegionStore{
    @Autowired
    RegionRepository repository;

    @Autowired
    TenantRepository tenantRepository;

    @Autowired
    RegionNameRepository regionNameRepository;

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
    public List<Region> retrieveByTenantCode(String tenantCode) {
        TenantJpo tenant = tenantRepository.getByCode(tenantCode);
        if (tenant.getId() == null) {
            return Collections.emptyList();
        }
        return this.retrieveByTenantId(tenant.getId());
    }

    @Override
    public Region addName(Integer regionSequence, RegionName regionName) {
        RegionJpo regionJpo = repository.getBySequence(regionSequence);
        RegionNameJpo regionNameJpo = RegionNameJpo.fromDomain(regionName);

        Set<String> langCodes = new HashSet<>();
        for (RegionNameJpo name: regionJpo.getNames()) {
            langCodes.add(name.getLangCode());
        }
        if (!langCodes.contains(regionName.getLangCode())) {
            regionNameJpo.setRegion(regionJpo);
            regionNameRepository.save(regionNameJpo);
        }
        return regionJpo.toDomain();
    }

}
