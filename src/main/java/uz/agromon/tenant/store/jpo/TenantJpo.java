package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import uz.agromon.tenant.domain.Tenant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TENANT")
public class TenantJpo {
    @Id
    Integer id;
    String country;
    String shortName;

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
}
