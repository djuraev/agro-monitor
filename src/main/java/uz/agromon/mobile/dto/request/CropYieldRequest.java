package uz.agromon.mobile.dto.request;

import uz.agromon.cropyield.domain.CropYield;

import java.util.ArrayList;
import java.util.List;

public class CropYieldRequest extends Request{
    //
    private String fieldId;
    private String cropName;
    private List<CropYieldData> values;

    public CropYieldRequest() {
        //
    }

    public CropYieldRequest(String fieldId, String cropName, List<CropYieldData> values) {
        //
        this.fieldId = fieldId;
        this.cropName = cropName;
        this.values = values;
    }

    public List<CropYield> toCropYieldDomain() {
        List<CropYield> domains = new ArrayList<>();
        Integer fid = Integer.parseInt(this.fieldId);
        for (CropYieldData cyd: values) {
            CropYield cropYield = new CropYield(fid, this.cropName, cyd.year, cyd.value);
            domains.add(cropYield);
        }
        return domains;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public List<CropYieldData> getValues() {
        return values;
    }

    public void setValues(List<CropYieldData> values) {
        this.values = values;
    }
}
