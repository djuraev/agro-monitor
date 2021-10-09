package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.Language;

import java.util.List;

public interface LanguageStore {
    Language create(Language language);
    boolean existsByName(String name);
    List<Language> retrieveAll();
    Language retrieveByCode(String code);
}
