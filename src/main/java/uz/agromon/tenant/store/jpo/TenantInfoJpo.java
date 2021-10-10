package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TENANT_INFO")
public class TenantInfoJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer sequence;
    Integer tenantId;
    String name;
    String land;
    Integer userCount;
    Integer fieldCount;
    Integer villageCount;
}
