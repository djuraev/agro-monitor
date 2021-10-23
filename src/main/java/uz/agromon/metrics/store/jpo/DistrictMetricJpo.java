package uz.agromon.metrics.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.metrics.domain.DistrictMetric;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="DISTRICT_METRIC")
public class DistrictMetricJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sequence;
    private Integer cropId;
    private Integer districtId;
    private Integer metricId;
    private String year;
    private String value;

    public DistrictMetricJpo(Integer sequence, Integer cropId, Integer districtId, Integer metricId, String year, String value) {
        //
        this.sequence = sequence;
        this.cropId = cropId;
        this.districtId = districtId;
        this.metricId = metricId;
        this.year = year;
        this.value = value;
    }

    public DistrictMetricJpo() {
        //
    }

    public DistrictMetricJpo(DistrictMetric metric) {
        //
        BeanUtils.copyProperties(metric, this);
    }

    public DistrictMetric toDomain() {
        DistrictMetric domain = new DistrictMetric();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    public static List<DistrictMetric> toDomains(List<DistrictMetricJpo> jpos) {
        return jpos.stream().map(DistrictMetricJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
}
