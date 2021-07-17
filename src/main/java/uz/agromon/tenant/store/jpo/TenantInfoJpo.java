package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TENANT_INFO")
public class TenantInfoJpo {
    @Id
    Integer sequence;
    Integer tenantId;
    String capital;
    String land;
    String userCount;
    String fieldCount;
    String villageCount;
}
