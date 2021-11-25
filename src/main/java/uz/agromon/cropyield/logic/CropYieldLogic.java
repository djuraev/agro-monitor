package uz.agromon.cropyield.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.service.CropYieldService;
import uz.agromon.cropyield.store.CropYieldStore;
import uz.agromon.mobile.dto.response.YearValue;

import java.util.ArrayList;
import java.util.Collections;
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
        if (cropYields.isEmpty()) {
            return Collections.emptyList();
        }
        Integer fieldId = cropYields.get(0).getFieldId();
        if (cropYieldStore.existsByFieldId(fieldId)) {
            cropYieldStore.deleteCropYield(fieldId);
        }
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

    @Override
    public List<YearValue> getFieldCropYieldYearValues(Integer fieldId) {
        List<YearValue> yearValues = new ArrayList<>();
        List<CropYield> cropYields = cropYieldStore.getFieldCropYield(fieldId);
        for (CropYield cy: cropYields) {
            yearValues.add(new YearValue(cy.getYear(), cy.getValue()));
        }
        return yearValues;
    }
}
