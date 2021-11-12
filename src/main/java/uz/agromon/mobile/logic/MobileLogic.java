package uz.agromon.mobile.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.service.CropYieldService;
import uz.agromon.field.service.FieldService;
import uz.agromon.mobile.dto.request.CropYieldRequest;
import uz.agromon.mobile.dto.response.CropYieldResponse;
import uz.agromon.mobile.service.MobileService;

import java.util.List;

@Service
public class MobileLogic implements MobileService {
    @Autowired
    CropYieldService cropYieldService;
    @Autowired
    FieldService fieldService;


    @Override
    public List<CropYield> saveCropYield(CropYieldRequest request) {
        List<CropYield> cropYields = request.toCropYieldDomain();
        return cropYieldService.save(cropYields);
    }

    @Override
    public CropYieldResponse getUserFieldCropYield(String username, String fieldId) {
        return null;
    }
}
