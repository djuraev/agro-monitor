package uz.agromon.metrics.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.metrics.domain.VillageMetric;
import uz.agromon.tenant.store.jpo.AgroMonEntity;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "VILLAGE_METRIC")
public class VillageMetricJpo extends AgroMonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sequence;
    private Integer villageId;
    private Integer metricId;
    private Integer cropId;
    @Column(unique = true, length = 10)
    private String year;
    @Column(length = 10)
    private String value;

    public VillageMetricJpo(Integer sequence, Integer villageId, Integer metricId, Integer cropId, String year, String value) {
        //
        this.sequence = sequence;
        this.villageId = villageId;
        this.metricId = metricId;
        this.cropId = cropId;
        this.year = year;
        this.value = value;
    }

    public VillageMetricJpo() {
        //
    }

    public VillageMetricJpo(VillageMetric villageMetric) {
        //
        BeanUtils.copyProperties(villageMetric, this);
    }

    public VillageMetric toDomain() {
        VillageMetric villageMetric = new VillageMetric();
        BeanUtils.copyProperties(this, villageMetric);
        return villageMetric;
    }

    public static List<VillageMetric> toDomains(List<VillageMetricJpo> jpos) {
        return jpos.stream().map(VillageMetricJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
