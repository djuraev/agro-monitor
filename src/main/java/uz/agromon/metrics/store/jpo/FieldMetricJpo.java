package uz.agromon.metrics.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.metrics.domain.FieldMetric;
import uz.agromon.metrics.domain.VillageMetric;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "FIELD_METRIC")
@Deprecated
public class FieldMetricJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sequence;
    private Integer fieldId;
    private Integer metricId;
    private Integer cropId;
    private String year;
    private String value;

    public FieldMetricJpo(FieldMetric fieldMetric) {
        //
        BeanUtils.copyProperties(fieldMetric, this);
    }

    public FieldMetricJpo() {
        //
    }

    public FieldMetric toDomain() {
        FieldMetric fieldMetric = new FieldMetric();
        BeanUtils.copyProperties(this, fieldMetric);
        return fieldMetric;
    }

    public static List<FieldMetric> toDomains(List<FieldMetricJpo> jpos) {
        return jpos.stream().map(FieldMetricJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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
