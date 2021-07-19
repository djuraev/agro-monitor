package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.Village;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="VILLAGE")
public class VillageJpo extends AgroMonEntity {
    Integer districtSequence;
    String name;

    public VillageJpo(){}
    public VillageJpo(Village village) {
        BeanUtils.copyProperties(village, this);
    }

    public Village toDomain(){
        Village village = new Village();
        BeanUtils.copyProperties(this, village);
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
}
