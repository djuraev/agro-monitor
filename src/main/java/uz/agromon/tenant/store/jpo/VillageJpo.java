package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.Village;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="VILLAGE")
public class VillageJpo extends AgroMonEntity {
    Integer districtSequence;
    String name;
    String coordinates;

    @JoinColumn(name = "village_sequence")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<VillageNameJpo> names;

    public VillageJpo(){}
    public VillageJpo(Village village) {
        names = new ArrayList<>();
        BeanUtils.copyProperties(village, this);
        names = VillageNameJpo.fromDomains(village.getNames());
    }

    public Village toDomain(){
        Village village = new Village();
        BeanUtils.copyProperties(this, village);
        village.setNames(this.names.stream().map(VillageNameJpo::toDomain).collect(Collectors.toList()));
        return village;
    }
    public static List<Village> toDomains(List<VillageJpo> jpos) {
        return jpos.stream().map(VillageJpo::toDomain).collect(Collectors.toList());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistrictSequence() {
        return districtSequence;
    }

    public void setDistrictSequence(Integer districtSequence) {
        this.districtSequence = districtSequence;
    }

    public List<VillageNameJpo> getNames() {
        return names;
    }

    public void setNames(List<VillageNameJpo> names) {
        this.names = names;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
