package uz.agromon.tenant.store;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.RegionName;
import uz.agromon.tenant.store.jpo.RegionJpo;
import uz.agromon.tenant.store.jpo.RegionNameJpo;
import uz.agromon.tenant.store.repo.RegionNameRepository;
import uz.agromon.tenant.store.repo.RegionRepository;

import java.util.List;


@Repository
public class RegionNameStoreLogic implements RegionNameStore{

    @Autowired
    RegionNameRepository regionNameRepository;

    @Autowired
    RegionRepository regionRepository;

    @Override
    public RegionName save(RegionName regionName) {
        RegionNameJpo jpo = RegionNameJpo.fromDomain(regionName);
        return regionNameRepository.save(jpo).toDomain();
    }

    @Override
    public List<RegionName> getNamesOfRegion(Integer regionSequence) {
        RegionJpo regionJpo = regionRepository.getBySequence(regionSequence);
        List<RegionNameJpo> regionNames =  regionJpo.getNames();
        return RegionNameJpo.toDomains(regionNames);
    }
}
