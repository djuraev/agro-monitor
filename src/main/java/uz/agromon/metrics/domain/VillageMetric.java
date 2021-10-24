package uz.agromon.metrics.domain;

public class VillageMetric {
    //
    private Integer villageId;
    private Integer metricId;
    private Integer cropId;
    private String year;
    private String value;

    public VillageMetric(Integer villageId, Integer metricId, Integer cropId, String year, String value) {
        //
        this.villageId = villageId;
        this.metricId = metricId;
        this.cropId = cropId;
        this.year = year;
        this.value = value;
    }

    public VillageMetric() {
        //
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
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