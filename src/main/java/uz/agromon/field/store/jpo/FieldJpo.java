package uz.agromon.field.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.field.domain.Field;
import uz.agromon.tenant.store.jpo.AgroMonEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="FIELD")
public class FieldJpo extends AgroMonEntity {
    private Integer userSequence;
    private Integer villageSequence;
    private String villageName;
    private String name;
    private String polygon;
    private String apiKey;
    private String center;
    private String cropType;
    private String area;
    private String comment;

    public FieldJpo() {
    }
    public FieldJpo(Field field) {
        BeanUtils.copyProperties(field, this);
    }
    public Field toDomain(){
        Field field = new Field();
        BeanUtils.copyProperties(this, field);
        return field;
    }
    public static List<Field> toDomains(List<FieldJpo> jpos){
        return jpos.stream().map(FieldJpo::toDomain).collect(Collectors.toList());
    }
    public Integer getUserSequence() {
        return userSequence;
    }

    public void setUserSequence(Integer userSequence) {
        this.userSequence = userSequence;
    }

    public Integer getVillageSequence() {
        return villageSequence;
    }

    public void setVillageSequence(Integer villageSequence) {
        this.villageSequence = villageSequence;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
