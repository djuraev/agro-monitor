package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.Language;
import uz.agromon.tenant.store.jpo.LanguageJpo;
import uz.agromon.tenant.store.repo.LanguageRepository;

import java.util.List;

@Repository
public class LanguageStoreLogic implements LanguageStore{
    @Autowired
    LanguageRepository repository;
    @Override
    public Language create(Language language) {
        LanguageJpo jpo = new LanguageJpo(language);
        return repository.save(jpo).toDomain();
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public List<Language> retrieveAll() {
        List<LanguageJpo> jpos = repository.getAllBy();
        return LanguageJpo.toDomains(jpos);
    }

    @Override
    public Language retrieveByCode(String code) {
        return repository.existsByCode(code).toDomain();
    }
}
