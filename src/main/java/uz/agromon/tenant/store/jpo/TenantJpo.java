package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Tenant;

import javax.persistence.*;
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
    String shortName;

    public TenantJpo(){}
    public TenantJpo(Tenant tenant) {
        BeanUtils.copyProperties(tenant, this);
    }
    public Tenant toDomain(){
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(this, tenant);
        return tenant;
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

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getShortName() {
        return shortName;
    }
}
