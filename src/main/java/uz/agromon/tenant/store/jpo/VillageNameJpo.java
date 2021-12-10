package uz.agromon.tenant.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.VillageName;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "VILLAGE_NAME")
public class VillageNameJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String langCode;
    String localName;

    @ManyToOne(cascade = CascadeType.ALL)
    private VillageJpo village;

    public VillageNameJpo() {
    }

    public static VillageNameJpo fromDomain(VillageName domain) {
        VillageNameJpo jpo = new VillageNameJpo();
        BeanUtils.copyProperties(domain, jpo);
        return jpo;
    }

    public static List<VillageNameJpo> fromDomains(List<VillageName> domains) {
        return domains.stream().map(VillageNameJpo::fromDomain).collect(Collectors.toList());
    }

    public VillageName toDomain() {
        VillageName domain = new VillageName();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String name) {
        this.localName = name;
    }

    public VillageJpo getVillage() {
        return village;
    }

    public void setVillage(VillageJpo village) {
        this.village = village;
    }
}
