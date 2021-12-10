package uz.agromon.tenant.store.jpo;

import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.DistrictName;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "DISTRICT_NAME")
public class DistrictNameJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer sequence;
    String langCode;
    String localName;

    @ManyToOne(cascade = CascadeType.ALL)
    DistrictJpo district;

    public DistrictNameJpo(Integer sequence, String langCode, String localName, DistrictJpo district) {
        this.sequence = sequence;
        this.langCode = langCode;
        this.localName = localName;
        this.district = district;
    }

    public DistrictName toDomain() {
        DistrictName domain = new DistrictName();
        BeanUtils.copyProperties(this, domain);
        return domain;
    }

    public static DistrictNameJpo fromDomain(DistrictName domain) {
        DistrictNameJpo jpo = new DistrictNameJpo();
        BeanUtils.copyProperties(domain, jpo);
        return jpo;
    }

    public static List<DistrictNameJpo> fromDomains(List<DistrictName> domains) {
        return domains.stream().map(DistrictNameJpo::fromDomain).collect(Collectors.toList());
    }

    public DistrictNameJpo() {

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

    public DistrictJpo getDistrict() {
        return district;
    }

    public void setDistrict(DistrictJpo district) {
        this.district = district;
    }
}
