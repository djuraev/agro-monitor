package uz.agromon.metrics.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import uz.agromon.metrics.store.jpo.VillageMetricJpo;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class VillageMetric {
    //
    private Integer villageId;
    private Integer metricId;
    private String metricName;
    private Integer cropId;
    private String cropName;
    private String year;
    private String value;

    public VillageMetric(Integer villageId, Integer metricId, String metricName, Integer cropId, String cropName, String year, String value) {
        this.villageId = villageId;
        this.metricId = metricId;
        this.metricName = metricName;
        this.cropId = cropId;
        this.cropName = cropName;
        this.year = year;
        this.value = value;
    }

    public VillageMetric() {
        //
    }

    public VillageMetricJpo toJpo() {
        VillageMetricJpo jpo = new VillageMetricJpo();
        BeanUtils.copyProperties(this, jpo);
        return jpo;
    }

    public static List<VillageMetricJpo> toJpos(List<VillageMetric> metrics) {
        return metrics.stream().map(VillageMetric::toJpo).collect(Collectors.toList());
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

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }
}
