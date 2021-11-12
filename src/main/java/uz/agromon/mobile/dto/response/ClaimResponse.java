package uz.agromon.mobile.dto.response;

import org.springframework.beans.BeanUtils;
import uz.agromon.claim.domain.Claim;
import java.util.List;
import java.util.stream.Collectors;

public class ClaimResponse extends Response {
    //
    private Integer sequence;
    private Integer username;
    private Integer fieldId;
    private String fieldName;
    private String cropType;
    private String areaTon;
    private String farmerName;
    private String farmerPhone;
    private String description;
    private String status;

    public ClaimResponse() {
        //
    }

    public ClaimResponse(Claim claim) {
        super();
        setResult(true);
        BeanUtils.copyProperties(claim, this);
    }

    public static ClaimResponse build(Claim claim) {
        return new ClaimResponse(claim);
    }

    public static List<ClaimResponse> toClaimResponse(List<Claim> claims) {
        return claims.stream().map(ClaimResponse::build).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getAreaTon() {
        return areaTon;
    }

    public void setAreaTon(String areaTon) {
        this.areaTon = areaTon;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerPhone() {
        return farmerPhone;
    }

    public void setFarmerPhone(String farmerPhone) {
        this.farmerPhone = farmerPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
