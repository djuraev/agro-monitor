package uz.agromon.tenant.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.RegionName;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "REGION_NAME")
public class RegionNameJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer sequence;
    String langCode;
    String localName;

    @ManyToOne(cascade = CascadeType.ALL)
    RegionJpo region;

    public RegionNameJpo(Integer sequence, String langCode, String localName, RegionJpo region) {
        this.sequence = sequence;
        this.langCode = langCode;
        this.localName = localName;
        this.region = region;
    }

    public RegionNameJpo () {

    }

    public static RegionNameJpo fromDomain(RegionName regionName) {
        RegionNameJpo jpo = new RegionNameJpo();
        BeanUtils.copyProperties(regionName, jpo);
        return jpo;
    }

    public static List<RegionNameJpo> fromDomains(List<RegionName> names) {
        return names.stream().map(RegionNameJpo::fromDomain).collect(Collectors.toList());
    }

    public RegionName toDomain() {
        RegionName regionName = new RegionName();
        BeanUtils.copyProperties(this, regionName);
        return regionName;
    }

    public static List<RegionName> toDomains(List<RegionNameJpo> names) {
        return names.stream().map(RegionNameJpo::toDomain).collect(Collectors.toList());
    }
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public RegionJpo getRegion() {
        return region;
    }

    public void setRegion(RegionJpo region) {
        this.region = region;
    }
}
