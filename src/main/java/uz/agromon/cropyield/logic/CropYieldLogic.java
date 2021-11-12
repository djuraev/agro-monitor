package uz.agromon.cropyield.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.service.CropYieldService;
import uz.agromon.cropyield.store.CropYieldStore;

import java.util.ArrayList;
import java.util.List;

@Service
public class CropYieldLogic implements CropYieldService {
    @Autowired
    CropYieldStore cropYieldStore;

    @Override
    public CropYield save(CropYield cropYield) {
        return cropYieldStore.save(cropYield);
    }

    @Override
    public List<CropYield> save(List<CropYield> cropYields) {
        List<CropYield> savedCropYields = new ArrayList<>();
        for (CropYield cropYield: cropYields) {
            CropYield scy = cropYieldStore.save(cropYield);
            savedCropYields.add(scy);
        }
        return savedCropYields;
    }

    @Override
    public List<CropYield> getFieldCropYield(Integer fieldId) {
        return cropYieldStore.getFieldCropYield(fieldId);
    }
}
