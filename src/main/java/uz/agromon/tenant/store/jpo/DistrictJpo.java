package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.District;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="DISTRICT")
public class DistrictJpo extends AgroMonEntity{
    Integer regionSequence;
    String name;

    @JoinColumn(name = "district_sequence")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<DistrictNameJpo> names;

    public DistrictJpo(){
    }

    public DistrictJpo(District district) {
        names = new ArrayList<>();
        BeanUtils.copyProperties(district, this);
        names = DistrictNameJpo.fromDomains(district.getNames());
    }

    public District toDomain(){
        District district = new District();
        BeanUtils.copyProperties(this, district);
        return district;
    }

    public static List<District> toDomains(List<DistrictJpo> jpos) {
        return jpos.stream().map(DistrictJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getRegionSequence() {
        return regionSequence;
    }

    public void setRegionSequence(Integer regionId) {
        this.regionSequence = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
