package uz.agromon.metrics.store;

import uz.agromon.metrics.domain.Crop;

import java.util.List;

public interface CropStore {
    Crop create(Crop crop);
    Crop retrieve(Integer id);
    Crop retrieve(Crop crop);
    List<Crop> getAllCrops();
}
