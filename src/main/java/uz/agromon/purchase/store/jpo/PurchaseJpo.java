package uz.agromon.purchase.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.purchase.domain.Purchase;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="PURCHASE")
public class PurchaseJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer sequence;
    String username;
    String fieldId;
    String fieldName;
    String cropName;
    String hectares;
    String farmerName;
    String phoneNumber;
    String status;

    public PurchaseJpo() {
        //
    }

    public PurchaseJpo(Purchase purchase) {
        BeanUtils.copyProperties(purchase, this);
    }

    public Purchase toDomain() {
        Purchase domain = new Purchase();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    public static List<Purchase> toDomains(List<PurchaseJpo> jpos) {
        return jpos.stream().map(PurchaseJpo::toDomain).collect(Collectors.toList());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getHectares() {
        return hectares;
    }

    public void setHectares(String hectares) {
        this.hectares = hectares;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
