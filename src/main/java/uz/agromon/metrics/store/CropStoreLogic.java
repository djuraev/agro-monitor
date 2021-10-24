package uz.agromon.metrics.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.store.jpo.CropJpo;
import uz.agromon.metrics.store.repo.CropRepository;

import java.util.List;

@Repository
public class CropStoreLogic implements CropStore {

    @Autowired
    CropRepository cropRepository;

    @Override
    public Crop create(Crop crop) {
        CropJpo jpo = new CropJpo(crop);
        return cropRepository.save(jpo).toDomain();
    }

    @Override
    public Crop retrieve(Integer id) {
        CropJpo jpo = cropRepository.getById(id);
        if (jpo == null) {
            throw new ResourceNotFoundException(CropJpo.class, "Crop not found");
        }
        return cropRepository.getById(id).toDomain();
    }

    @Override
    public Crop retrieve(Crop crop) {
        return cropRepository.getByName(crop.getName()).toDomain();
    }

    @Override
    public List<Crop> getAllCrops() {
        List<CropJpo> jpos = cropRepository.getAllBy();
        return CropJpo.toDomains(jpos);
    }
}
