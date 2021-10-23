package uz.agromon.metrics.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.metrics.domain.Metric;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="METRIC")
public class MetricJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sequence;
    private String name;
    private String extraInfo;
    private String code;

    public MetricJpo() {
    }

    public MetricJpo(Metric metric) {
        //
        BeanUtils.copyProperties(metric, this);
    }

    public MetricJpo(Integer sequence, String name, String extraInfo, String code) {
        //
        this.sequence = sequence;
        this.name = name;
        this.extraInfo = extraInfo;
        this.code = code;
    }

    public Metric toDomain() {
        Metric domain = new Metric();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    public static List<Metric> toDomains(List<MetricJpo> jpos) {
        return jpos.stream().map(MetricJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
