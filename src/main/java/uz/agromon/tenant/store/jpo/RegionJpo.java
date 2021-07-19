package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.Tenant;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="REGION")
public class RegionJpo extends AgroMonEntity{
    String name;

    public RegionJpo() {
    }
    public RegionJpo(Integer sequence, Integer tenantId, String name){
        super.sequence =sequence;
        super.tenantId = tenantId;
        this.name = name;
    }

    public RegionJpo(Region region) {
        BeanUtils.copyProperties(region, this);
    }

    public Region toDomain(){
        Region region = new Region();
        BeanUtils.copyProperties(this, region);
        return region;
    }

    public static List<Region> toDomains(List<RegionJpo> jpos) {
        return jpos.stream().map(RegionJpo::toDomain).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
