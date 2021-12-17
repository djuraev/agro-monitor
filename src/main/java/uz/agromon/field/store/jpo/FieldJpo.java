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
    private String username;
    private Integer villageSequence;
    private String villageName;
    private String name;
    private String polygon;
    private String apiKey;
    private String center;
    private Integer cropId;
    private Integer cropName;
    private String agromonArea;
    private String userArea;
    private String comment;

    public FieldJpo() {
        //
    }

    public FieldJpo(Field field) {
        BeanUtils.copyProperties(field, this);
    }

    public Field toDomain(){
        Field field = new Field();
        BeanUtils.copyProperties(this, field);
        field.setFieldId(this.getSequence());
        return field;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public static List<Field> toDomains(List<FieldJpo> jpos){
        return jpos.stream().map(FieldJpo::toDomain).collect(Collectors.toList());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getAgromonArea() {
        return agromonArea;
    }

    public void setAgromonArea(String area) {
        this.agromonArea = area;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCropName() {
        return cropName;
    }

    public void setCropName(Integer cropName) {
        this.cropName = cropName;
    }
}
