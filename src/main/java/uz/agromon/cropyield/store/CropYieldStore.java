package uz.agromon.cropyield.store;

import uz.agromon.cropyield.domain.CropYield;

import java.util.List;

public interface CropYieldStore {
    CropYield save(CropYield cropYield);
    List<CropYield> getFieldCropYield(Integer fieldId);
}
