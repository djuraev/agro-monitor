package uz.agromon.metrics.service;

import uz.agromon.metrics.domain.Crop;

import java.util.List;

public interface CropService {
    Crop save(Crop crop);
    Crop getCropById(Integer id);
    List<Crop> getAllCrops();
}
