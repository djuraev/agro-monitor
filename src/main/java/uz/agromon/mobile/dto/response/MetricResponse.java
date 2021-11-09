package uz.agromon.mobile.dto.response;

import uz.agromon.metrics.domain.DistrictMetric;
import uz.agromon.metrics.domain.VillageMetric;

public class MetricResponse {
    String cropName;
    String metricName;
    String year;
    String value;

    public MetricResponse() {
        //
    }

    public MetricResponse (VillageMetric villageMetric) {
        this.cropName = villageMetric.getCropId().toString();
        this.metricName = villageMetric.getMetricId().toString();
        this.year = villageMetric.getYear();
        this.value = villageMetric.getValue();
    }

    public MetricResponse(DistrictMetric districtMetric) {
        this.cropName = districtMetric.getCropId().toString();
        this.metricName = districtMetric.getMetricId().toString();
        this.year = districtMetric.getYear();
        this.value = districtMetric.getValue();
    }

    public MetricResponse(String cropName, String metricName, String year, String value) {
        //
        this.cropName = cropName;
        this.metricName = metricName;
        this.year = year;
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
