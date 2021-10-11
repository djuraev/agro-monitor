package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.domain.Tenant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="REGION")
public class RegionJpo extends AgroMonEntity{
    String name;

    @JoinColumn(name = "region_sequence")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<RegionNameJpo> names;

    public RegionJpo() {
        names = new ArrayList<>();
    }

    public RegionJpo(Integer sequence, Integer tenantId, String name){
        super.sequence = sequence;
        super.tenantId = tenantId;
        this.name = name;
    }

    public RegionJpo(Region region) {
        names = new ArrayList<>();
        BeanUtils.copyProperties(region, this);
        this.names = RegionNameJpo.fromDomains(region.getNames());
    }

    public Region toDomain(){
        Region region = new Region();
        BeanUtils.copyProperties(this, region);
        region.setSequence(super.sequence);
        region.setNames(this.names.stream().map(RegionNameJpo::toDomain).collect(Collectors.toList()));
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

    public List<RegionNameJpo> getNames() {
        return names;
    }

    public void setNames(List<RegionNameJpo> names) {
        this.names = names;
    }
}
