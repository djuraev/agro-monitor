package uz.agromon.cropyield.domain;

public class CropYield {
    //
    private Integer fieldId;
    private String cropName;
    private String year;
    private String value;

    public CropYield() {
        //
    }

    public CropYield(Integer fieldId, String cropName, String year, String value) {
        //
        this.fieldId = fieldId;
        this.cropName = cropName;
        this.year = year;
        this.value = value;
    }


    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
