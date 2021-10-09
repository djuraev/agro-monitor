package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.TenantName;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="TENANT_NAME")
public class TenantNameJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer sequence;
    String langCode;
    String name;
    String tenantCode;

    @ManyToOne(cascade = CascadeType.ALL)
    private TenantJpo tenant;

    public TenantNameJpo() {
    }

    public static TenantNameJpo fromDomain(TenantName tenantName) {
        TenantNameJpo jpo = new TenantNameJpo();
        BeanUtils.copyProperties(tenantName, jpo);
        return jpo;
    }

    public static List<TenantNameJpo> fromDomains(List<TenantName> tenantNames) {
        return tenantNames.stream().map(TenantNameJpo::fromDomain).collect(Collectors.toList());
    }

    public TenantName toDomain() {
        TenantName tenantName = new TenantName();
        tenantName.setLangCode(langCode);
        tenantName.setName(name);
        return tenantName;
    }

    List<TenantName> toDomains(List<TenantNameJpo> jpos) {
        return jpos.stream().map(TenantNameJpo::toDomain).collect(Collectors.toList());
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

    public TenantJpo getTenant() {
        return tenant;
    }

    public void setTenant(TenantJpo tenant) {
        this.tenant = tenant;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String lanCode) {
        this.langCode = lanCode;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}
