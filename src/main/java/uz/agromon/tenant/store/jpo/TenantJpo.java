package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Tenant;

import javax.persistence.*;
import java.util.*;
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
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    Set<TenantNameJpo> names;

    public TenantJpo(){
        names = new HashSet<>();
    }

    public TenantJpo(Tenant tenant) {
        names = new HashSet<>();
        BeanUtils.copyProperties(tenant, this);
        this.names = TenantNameJpo.fromDomains(tenant.getNames());
        this.names.forEach(name -> name.setTenantCode(this.getCode()));
    }

    public Tenant toDomain(){
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(this, tenant);
        tenant.setNames(this.names.stream().filter(Objects::nonNull).map(TenantNameJpo::toDomain).collect(Collectors.toSet()));
        return tenant;
    }

    public Set<TenantNameJpo> getNames() {
        return names;
    }

    public void setNames(Set<TenantNameJpo> names) {
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
