package uz.agromon.mobile.logic;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.service.CropYieldService;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.service.CropService;
import uz.agromon.metrics.service.DistrictMetricService;
import uz.agromon.metrics.service.MetricService;
import uz.agromon.metrics.service.VillageMetricService;
import uz.agromon.mobile.dto.request.CropYieldRequest;
import uz.agromon.mobile.dto.request.BuyInsuranceRequest;
import uz.agromon.mobile.dto.response.*;
import uz.agromon.mobile.dto.response.dto.CountryDto;
import uz.agromon.mobile.dto.response.dto.DistrictDto;
import uz.agromon.mobile.dto.response.dto.RegionDto;
import uz.agromon.mobile.service.MobileService;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.service.PurchaseService;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.service.VillageService;
import uz.agromon.tenant.store.DistrictStore;
import uz.agromon.tenant.store.RegionStore;
import uz.agromon.tenant.store.TenantStore;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.UserStore;

import java.util.List;

@Service
public class MobileLogic implements MobileService {
    @Autowired
    CropYieldService cropYieldService;
    @Autowired
    FieldService fieldService;
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    VillageMetricService villageMetricService;
    @Autowired
    DistrictMetricService districtMetricService;
    @Autowired
    MetricService metricService;
    @Autowired
    VillageService villageService;
    @Autowired
    CropService cropService;
    @Autowired
    UserStore userStore;

    @Autowired
    TenantStore tenantStore;
    @Autowired
    RegionStore regionStore;
    @Autowired
    DistrictStore districtStore;

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
        return new FarmerInsurancePurchases(purchases);
    }

    @Override
    public GraphViewResponse getGraphViewForField(String fieldId, String metricId) {
        Integer fid = Integer.parseInt(fieldId);
        Integer mid = Integer.parseInt(metricId);
        GraphViewResponse graphViewResponse = new GraphViewResponse();


        Field field = fieldService.getField(fid);
        Metric metric = metricService.getMetricById(mid);
        List<Crop> allCrops = cropService.getAllCrops();
        String fieldCropName = "";
        for (Crop crop: allCrops) {
            CropValues cropValues = new CropValues();
            List<YearValue> metricValues;
            metricValues = villageMetricService.getVillageMetricsYearValues(field.getVillageSequence(), mid, crop.getSequence());

            if (metricValues.isEmpty()) {
                Integer did = villageService.getVillage(field.getVillageSequence()).getDistrictSequence();
                metricValues = districtMetricService.getDistrictMetricYearValues(did, mid, crop.getSequence());
                graphViewResponse.setDistrictId(String.valueOf(did));
            }
            cropValues.setCropName(crop.getName());
            cropValues.setChartInfoList(metricValues);
            cropValues.setName(metric.getName());
            graphViewResponse.getValues().add(cropValues);
            if (field.getCropId().equals(crop.getSequence())) {
                fieldCropName = crop.getName();
            }
        }
        List<YearValue> cropYieldValues = cropYieldService.getFieldCropYieldYearValues(fid);
        CropValues cropValues = new CropValues();
        cropValues.setName("cropYield");
        cropValues.setCropName(fieldCropName);
        cropValues.setChartInfoList(cropYieldValues);
        graphViewResponse.getValues().add(cropValues);

        graphViewResponse.setFieldId(fieldId);
        graphViewResponse.setMetricId(metricId);
        graphViewResponse.setMetricName(metric.getName());

        return graphViewResponse;
    }

    @Override
    public FindInsuranceResponse findUserInsurance(String insuNumber, String birthday, String districtId) {
        Integer did = Integer.parseInt(districtId);
        User user = userStore.retrieve(birthday, insuNumber, did);
        if (user.getInsuranceNumber() == null) {
            FindInsuranceResponse response = new FindInsuranceResponse();
            response.setMessage("Cannot find Insurance Number");
            return response;
        }
        return new FindInsuranceResponse(user.getInsuranceNumber());
    }

    @Override
    public FindPasswordResponse findUserPassword(String birthday, String phone, String insuNumber, String districtId) {
        Integer did = Integer.parseInt(districtId);
        User user = userStore.retrieve(birthday, phone, insuNumber, did);
        return new FindPasswordResponse(user.getPassword());
    }

    @Override
    public CountryResponse getCountries() {
        List<Tenant> tenants = tenantStore.retrieveAll();
        CountryResponse countryResponse = new CountryResponse();
        for (Tenant t: tenants) {
            CountryDto countryDto = new CountryDto(t.getId(), t.getCountry());
            countryResponse.getCountries().add(countryDto);
        }
        return countryResponse;
    }

    @Override
    public RegionResponse getRegions(String countryId) {
        Integer tid = Integer.parseInt(countryId);
        List<Region> regions = regionStore.retrieveByTenantId(tid);
        RegionResponse response = new RegionResponse();
        for (Region r: regions) {
            response.getRegions().add(new RegionDto(r.getSequence(), r.getName()));
        }
        return response;
    }

    @Override
    public DistrictResponse getDistricts(String regionId) {
        Integer rid = Integer.parseInt(regionId);
        List<District> districts = districtStore.retrieveByRegion(rid);
        DistrictResponse response = new DistrictResponse();
        for (District district: districts) {
            response.getDistricts().add(new DistrictDto(district.getSequence(), district.getName()));
        }
        return response;
    }
}
