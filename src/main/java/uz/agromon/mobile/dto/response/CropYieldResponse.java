package uz.agromon.mobile.dto.response;

import uz.agromon.cropyield.domain.CropYield;
import uz.agromon.mobile.dto.request.CropYieldData;

import java.util.ArrayList;
import java.util.List;

public class CropYieldResponse extends Response {
    private String fieldId;
    private String fieldName;
    private String cropName;
    private List<CropYieldData> values;

    public CropYieldResponse() {
        //
    }

    public CropYieldResponse(List<CropYield> cropYields, String fieldName) {
        if (!cropYields.isEmpty()) {
            setResult(true);
            this.fieldId = cropYields.get(0).getFieldId().toString();
            this.cropName = cropYields.get(0).getCropName();
            this.fieldName = fieldName;
            values = new ArrayList<>();
            for (CropYield cy: cropYields) {
                values.add(new CropYieldData(cy.getYear(), cy.getValue()));
            }
        }
    }
    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
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
