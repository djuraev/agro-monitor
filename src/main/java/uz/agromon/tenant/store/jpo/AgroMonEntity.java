package uz.agromon.tenant.store.jpo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AgroMonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer sequence;
    Integer tenantId;

    protected void copy(final AgroMonEntity source)
    {
        this.sequence = source.sequence;
        this.tenantId = source.tenantId;
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
}
