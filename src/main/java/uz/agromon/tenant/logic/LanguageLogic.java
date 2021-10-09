package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.Language;
import uz.agromon.tenant.service.LanguageService;
import uz.agromon.tenant.store.LanguageStore;

import java.util.List;

@Service
public class LanguageLogic implements LanguageService {
    @Autowired
    LanguageStore languageStore;

    @Override
    public Language create(Language language) {
        return languageStore.create(language);
    }

    @Override
    public List<Language> retrieveAll() {
        return languageStore.retrieveAll();
    }
}
