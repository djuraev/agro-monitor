package uz.agromon.mobile.logic;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.service.CropYieldService;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.mobile.dto.request.CropYieldRequest;
import uz.agromon.mobile.dto.request.BuyInsuranceRequest;
import uz.agromon.mobile.dto.response.BuyInsuranceResponse;
import uz.agromon.mobile.dto.response.CropYieldResponse;
import uz.agromon.mobile.dto.response.FarmerInsurancePurchases;
import uz.agromon.mobile.service.MobileService;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.service.PurchaseService;

import java.util.List;

@Service
public class MobileLogic implements MobileService {
    @Autowired
    CropYieldService cropYieldService;
    @Autowired
    FieldService fieldService;
    @Autowired
    PurchaseService purchaseService;

    @Override
    public List<CropYield> saveCropYield(CropYieldRequest request) {
        List<CropYield> cropYields = request.toCropYieldDomain();
        return cropYieldService.save(cropYields);
    }

    @Override
    public CropYieldResponse getUserFieldCropYield(String username, String fieldId) {
        Integer fid = Integer.parseInt(fieldId);
        if (!fieldService.isUserFieldOwner(username, fid)) {
            CropYieldResponse response = new CropYieldResponse();
            response.setResult(false);
            response.setMessage("User doesn't have own field.");
            return response;
        }
        Field field = fieldService.getField(fid);
        List<CropYield> cropYields = cropYieldService.getFieldCropYield(fid);
        return new CropYieldResponse(cropYields, field.getName());
    }

    @Override
    public BuyInsuranceResponse buyInsurance(BuyInsuranceRequest buyInsurance) {
        Purchase purchase = new Purchase();
        BeanUtils.copyProperties(buyInsurance, purchase);
        purchase = purchaseService.save(purchase);
        BuyInsuranceResponse savedRequest = new BuyInsuranceResponse();
        BeanUtils.copyProperties(purchase, savedRequest);
        savedRequest.setResult(true);
        return savedRequest;
    }

    @Override
    public FarmerInsurancePurchases getFarmerPurchases(String username) {
        List<Purchase> purchases = purchaseService.getFarmerPurchases(username);
        FarmerInsurancePurchases farmerPurchases = new FarmerInsurancePurchases(purchases);
        return farmerPurchases;
    }


}
