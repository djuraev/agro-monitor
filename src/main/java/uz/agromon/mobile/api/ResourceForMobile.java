package uz.agromon.mobile.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.claim.domain.Claim;
import uz.agromon.claim.service.ClaimService;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.service.CropYieldService;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.service.CropService;
import uz.agromon.metrics.service.MetricService;
import uz.agromon.mobile.dto.request.*;
import uz.agromon.mobile.dto.response.*;
import uz.agromon.mobile.service.MUserService;
import uz.agromon.mobile.service.MobileService;
import uz.agromon.purchase.service.PurchaseService;
import uz.agromon.tenant.domain.ApiInfo;
import uz.agromon.tenant.service.ApiInfoService;
import uz.agromon.user.domain.User;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/mobile")
public class ResourceForMobile {

    @Autowired
    MUserService userService;

    @Autowired
    ApiInfoService apiInfoService;
    @Autowired
    FieldService fieldService;
    @Autowired
    CropService cropService;
    @Autowired
    ClaimService claimService;
    @Autowired
    CropYieldService cropYieldService;
    @Autowired
    MobileService mobileService;
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    MetricService metricService;

    @PostMapping(value = "/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = userService.login(request.username, request.password);
        ApiInfo apiInfo = apiInfoService.retrieve("agromon");
        LoginResponse loginResponse = LoginResponse.build(user, apiInfo);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/demo")
    ResponseEntity<DemoResponse> getDemo() {
        ApiInfo apiInfo = apiInfoService.retrieve("demo");
        DemoResponse demoResponse = new DemoResponse(apiInfo.getApiKey());
        return ResponseEntity.ok(demoResponse);
    }

    @GetMapping(value = "/info")
    ResponseEntity<AboutResponse> getAboutInfo() {
        ApiInfo aboutInfo = apiInfoService.retrieve("about");
        AboutResponse aboutResponse = new AboutResponse(aboutInfo.getApiKey());
        return ResponseEntity.ok(aboutResponse);
    }

    @GetMapping(value = "/user/fields/{username}")
    ResponseEntity<FieldsResponse> getUserFields(@PathVariable String username) {
        List<Field> fields = fieldService.getFieldsOfUser(username);
        return ResponseEntity.ok(new FieldsResponse(fields));
    }

    @GetMapping(value = "/crops")
    ResponseEntity<CropsResponse> getAllCrops() {
        List<Crop> crops = cropService.getAllCrops();
        CropsResponse response = new CropsResponse(crops);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/claim")
    ResponseEntity<ClaimResponse> createUserClaim(@RequestBody Claim claim) {
        Claim savedClaim = claimService.createClaim(claim);
        ClaimResponse claimResponse = new ClaimResponse(savedClaim);
        return ResponseEntity.ok(claimResponse);
    }

    @GetMapping(value = "/claims/{username}")
    ResponseEntity<?> getUserClaims(@PathVariable String username) {
        List<Claim> claims = claimService.getAllUserClaim(username);
        ClaimsResponse response = new ClaimsResponse(claims);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/cropYield")
    ResponseEntity<?> saveCropYieldData(@RequestBody CropYieldRequest request) {
        List<CropYield> savedCY = mobileService.saveCropYield(request);
        CropYieldResponse response = new CropYieldResponse(savedCY, "");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/cropYields/{username}/{fieldId}")
    ResponseEntity<?> getFieldCropYield(@PathVariable String username, @PathVariable String fieldId) {
        CropYieldResponse response = mobileService.getUserFieldCropYield(username, fieldId);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/purchase")
    ResponseEntity<?> saveFarmerPurchase(@RequestBody BuyInsuranceRequest buyInsuranceRequest) {
        BuyInsuranceResponse response = mobileService.buyInsurance(buyInsuranceRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/purchases/{username}")
    ResponseEntity<?> getFarmerPurchases(@PathVariable String username) {
        FarmerInsurancePurchases purchases = mobileService.getFarmerPurchases(username);
        return ResponseEntity.ok(purchases);
    }

    @GetMapping(value = "/graphview/{fieldId}/{metricId}")
    ResponseEntity<?> getGraphViewData(@PathVariable String fieldId, @PathVariable String metricId) {
        GraphViewResponse graphView = mobileService.getGraphViewForField(fieldId, metricId);
        return ResponseEntity.ok(graphView);
    }

    @GetMapping(value = "/metrics")
    ResponseEntity<?> getAllMetrics() {
        List<Metric> metrics = metricService.getAllMetrics();
        MetricsResponse response = new MetricsResponse();
        response.setList(metrics);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/findInsurance")
    ResponseEntity<?> findInsuranceNumber(@RequestBody FindInsuranceRequest request) {
        FindInsuranceResponse resp = mobileService.findUserInsurance(request.getPhoneNumber(), request.getBirthday(), request.getDistrictId());
        return ResponseEntity.ok(resp);
    }

    @PostMapping(value = "/findPassword")
    ResponseEntity<?> findPassword(@RequestBody FindPasswordRequest request) {
        FindPasswordResponse response = mobileService.findUserPassword(request.getBirthday(), request.getPhoneNumber(), request.getInsurance(), request.getDistrictId());
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/countries")
    ResponseEntity<?> getAllCountries() {
        CountryResponse countryResponse = mobileService.getCountries();
        return ResponseEntity.ok(countryResponse);
    }

    @GetMapping(value = "/regions/{countryId}")
    ResponseEntity<?> getRegionsOfCountry(@PathVariable String countryId) {
        RegionResponse response = mobileService.getRegions(countryId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/districts/{regionId}")
    ResponseEntity<?> getDistrictsOfRegion(@PathVariable String regionId) {
        DistrictResponse response = mobileService.getDistricts(regionId);
        return ResponseEntity.ok(response);
    }
}
