package uz.agromon.claim.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.claim.domain.Claim;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="CLAIM")
public class ClaimJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sequence;
    private Integer tenantId;
    private Integer userSequence;
    private Integer fieldSequence;
    private String reason;
    private String otherInfo;
    private String status;

    public ClaimJpo(Integer sequence, Integer tenantId, Integer userSequence, Integer fieldSequence, String reason, String otherInfo, String status) {
        //
        this.sequence = sequence;
        this.tenantId = tenantId;
        this.userSequence = userSequence;
        this.fieldSequence = fieldSequence;
        this.reason = reason;
        this.otherInfo = otherInfo;
        this.status = status;
    }

    public ClaimJpo() {
        //
    }

    public ClaimJpo(Claim claim) {
        //
        BeanUtils.copyProperties(claim, this);
    }

    public Claim toDomain() {
        Claim domain = new Claim();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    public static List<Claim> toDomains(List<ClaimJpo> jpos) {
        return jpos.stream().map(ClaimJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getUserSequence() {
        return userSequence;
    }

    public void setUserSequence(Integer userSequence) {
        this.userSequence = userSequence;
    }

    public Integer getFieldSequence() {
        return fieldSequence;
    }

    public void setFieldSequence(Integer fieldSequence) {
        this.fieldSequence = fieldSequence;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
