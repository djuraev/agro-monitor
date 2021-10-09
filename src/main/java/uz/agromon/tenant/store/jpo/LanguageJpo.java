package uz.agromon.tenant.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.domain.Language;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="LANGUAGE")
public class LanguageJpo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sequence;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String code;

    String nativeName;

    public LanguageJpo(Language language) {
        BeanUtils.copyProperties(language, this);
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public LanguageJpo() {

    }

    public Language toDomain() {
        Language language = new Language();
        BeanUtils.copyProperties(this, language);
        return language;
    }
    public static List<Language> toDomains(List<LanguageJpo> jpos) {
        return jpos.stream().map(LanguageJpo::toDomain).collect(Collectors.toList());
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
