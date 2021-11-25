package uz.agromon.cropyield.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.store.jpo.CropYieldJpo;
import uz.agromon.cropyield.store.repo.CropYieldRepository;

import java.util.List;

@Repository
public class CropYieldStoreLogic implements CropYieldStore{
    @Autowired
    CropYieldRepository repository;

    @Override
    public CropYield save(CropYield cropYield) {
        CropYieldJpo jpo = new CropYieldJpo(cropYield);
        return repository.save(jpo).toDomain();
    }

    @Override
    public List<CropYield> getFieldCropYield(Integer fieldId) {
        List<CropYieldJpo> jpos = repository.getAllByFieldId(fieldId);
        return CropYieldJpo.toDomains(jpos);
    }

    @Override
    public void deleteCropYield(Integer fieldId) {
        repository.deleteAllByFieldId(fieldId);
    }

    @Override
    public boolean existsByFieldId(Integer fieldId) {
        return repository.existsByFieldId(fieldId);
    }
}
