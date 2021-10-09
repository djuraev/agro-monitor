package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Tenant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="TENANT")
public class TenantJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(unique = true)
    String country;

    @Column(unique = true)
    String code;

    @JoinColumn(name = "tenant_id")
    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    List<TenantNameJpo> names;

    public TenantJpo(){}

    public TenantJpo(Tenant tenant) {
        names = new ArrayList<>();
        BeanUtils.copyProperties(tenant, this);
        this.names = TenantNameJpo.fromDomains(tenant.getNames());
        this.names.forEach(name -> name.setTenantCode(this.getCode()));
    }

    public Tenant toDomain(){
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(this, tenant);
        tenant.setNames(this.names.stream().map(TenantNameJpo::toDomain).collect(Collectors.toList()));
        return tenant;
    }

    public List<TenantNameJpo> getNames() {
        return names;
    }

    public void setNames(List<TenantNameJpo> names) {
        this.names = names;
    }

    public static List<Tenant> toDomains(List<TenantJpo> jpos) {
        return jpos.stream().map(TenantJpo::toDomain).collect(Collectors.toList());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCode(String shortName) {
        this.code = shortName;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

}
