package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.Language;

import java.util.List;

public interface LanguageService {
    Language create(Language language);
    List<Language> retrieveAll();
}
