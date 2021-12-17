package uz.agromon.mobile.service;

import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.mobile.dto.request.CropYieldRequest;
import uz.agromon.mobile.dto.request.BuyInsuranceRequest;
import uz.agromon.mobile.dto.response.*;

import java.util.List;

public interface MobileService {
    List<CropYield> saveCropYield(CropYieldRequest request);
    CropYieldResponse getUserFieldCropYield(String username, String fieldId);
    BuyInsuranceResponse buyInsurance(BuyInsuranceRequest buyInsurance);
    FarmerInsurancePurchases getFarmerPurchases(String username);
    GraphViewResponse getGraphViewForField(String fieldId, String metricId);
    FindInsuranceResponse findUserInsurance(String phoneNumber, String birthday, String districtId);
    FindPasswordResponse findUserPassword(String birthday, String phone, String insuNumber, String districtId);
    CountryResponse getCountries();
    RegionResponse getRegions(String countryId);
    DistrictResponse getDistricts(String regionId);
}
