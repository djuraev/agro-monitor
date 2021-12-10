package uz.agromon.mobile.logic;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.cropyield.service.CropYieldService;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.domain.Metric;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.metrics.service.CropService;
import uz.agromon.metrics.service.DistrictMetricService;
import uz.agromon.metrics.service.MetricService;
import uz.agromon.metrics.service.VillageMetricService;
import uz.agromon.mobile.dto.request.CropYieldRequest;
import uz.agromon.mobile.dto.request.BuyInsuranceRequest;
import uz.agromon.mobile.dto.response.*;
import uz.agromon.mobile.service.MobileService;
import uz.agromon.purchase.domain.Purchase;
import uz.agromon.purchase.service.PurchaseService;
import uz.agromon.tenant.service.VillageService;

import java.util.ArrayList;
import java.util.HashMap;
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
            graphViewResponse.getValues().add(cropValues);
        }
        List<YearValue> cropYieldValues = cropYieldService.getFieldCropYieldYearValues(fid);
        CropValues cropValues = new CropValues();
        cropValues.setCropName("cropYield");
        cropValues.setChartInfoList(cropYieldValues);
        graphViewResponse.getValues().add(cropValues);

        graphViewResponse.setFieldId(fieldId);
        graphViewResponse.setMetricId(metricId);
        graphViewResponse.setMetricName(metric.getName());

        return graphViewResponse;
    }
}
