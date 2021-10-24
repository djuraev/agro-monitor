package uz.agromon.metrics.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.service.CropService;
import uz.agromon.metrics.store.CropStore;

import java.util.List;

@Service
public class CropLogic implements CropService {
    @Autowired
    CropStore cropStore;

    @Override
    public Crop save(Crop crop) {
        return cropStore.create(crop);
    }

    @Override
    public Crop getCropById(Integer id) {
        return cropStore.retrieve(id);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropStore.getAllCrops();
    }
}
