package uz.agromon.mobile.service;

import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.mobile.dto.request.CropYieldRequest;
import uz.agromon.mobile.dto.request.BuyInsuranceRequest;
import uz.agromon.mobile.dto.response.BuyInsuranceResponse;
import uz.agromon.mobile.dto.response.CropYieldResponse;
import uz.agromon.mobile.dto.response.FarmerInsurancePurchases;

import java.util.List;

public interface MobileService {
    List<CropYield> saveCropYield(CropYieldRequest request);
    CropYieldResponse getUserFieldCropYield(String username, String fieldId);
    BuyInsuranceResponse buyInsurance(BuyInsuranceRequest buyInsurance);
    FarmerInsurancePurchases getFarmerPurchases(String username);
}
