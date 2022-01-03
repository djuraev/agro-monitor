package uz.agromon.metrics.domain;

public class DistrictMetric {
    //
    private Integer cropId;
    private String cropName;
    private Integer districtId;
    private Integer metricId;
    private String metricName;
    private String year;
    private String value;

    public DistrictMetric(Integer cropId, Integer districtId, Integer metricId, String year, String value) {
        //
        this.cropId = cropId;
        this.districtId = districtId;
        this.metricId = metricId;
        this.year = year;
        this.value = value;
    }

    public DistrictMetric() {
        //
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getMetricId() {
        return metricId;
    }

    public void setMetricId(Integer metricId) {
        this.metricId = metricId;
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

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }
}
