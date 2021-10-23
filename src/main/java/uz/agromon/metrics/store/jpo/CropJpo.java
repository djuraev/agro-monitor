package uz.agromon.metrics.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.metrics.domain.Crop;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="CROP")
public class CropJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sequence;
    private String name;
    private String extraInfo;
    private String code;

    public CropJpo(Crop crop) {
        BeanUtils.copyProperties(crop, this);
    }

    public Crop toDomain() {
        Crop domain = new Crop();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    public static List<Crop> toDomains(List<CropJpo> jpos) {
        return jpos.stream().map(CropJpo::toDomain).collect(Collectors.toList());
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
