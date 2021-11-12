package uz.agromon.cropyield.service;

import uz.agromon.cropyield.domain.CropYield;

import java.util.List;

public interface CropYieldService {
    CropYield save(CropYield cropYield);
    List<CropYield> save(List<CropYield> cropYields);
    List<CropYield> getFieldCropYield(Integer fieldId);
}
