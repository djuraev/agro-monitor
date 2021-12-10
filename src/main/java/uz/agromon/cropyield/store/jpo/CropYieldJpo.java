package uz.agromon.cropyield.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.cropyield.domain.CropYield;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="CROP_YIELD")
public class CropYieldJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer fieldId;
    private String cropName;
    private String year;
    private String value;

    public CropYieldJpo(CropYield cropYield) {
        BeanUtils.copyProperties(cropYield, this);
    }

    public CropYieldJpo() {
        //
    }

    public CropYield toDomain() {
        CropYield cropYield = new CropYield();
        BeanUtils.copyProperties(this, cropYield);
        return cropYield;
    }

    public static List<CropYield> toDomains(List<CropYieldJpo> jpos) {
        return jpos.stream().map(CropYieldJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
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
