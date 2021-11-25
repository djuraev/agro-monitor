package uz.agromon.metrics.domain;

@Deprecated
public class FieldMetric {
    //
    private Integer fieldId;
    private Integer metricId;
    private Integer cropId;
    private String year;
    private String value;

    public FieldMetric(Integer fieldId, Integer metricId, Integer cropId, String year, String value) {
        //
        this.fieldId = fieldId;
        this.metricId = metricId;
        this.cropId = cropId;
        this.year = year;
        this.value = value;
    }

    public FieldMetric() {
        //
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getMetricId() {
        return metricId;
    }

    public void setMetricId(Integer metricId) {
        this.metricId = metricId;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
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
