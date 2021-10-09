package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.tenant.domain.TenantName;
import uz.agromon.tenant.store.jpo.LanguageJpo;
import uz.agromon.tenant.store.jpo.TenantJpo;
import uz.agromon.tenant.store.jpo.TenantNameJpo;
import uz.agromon.tenant.store.repo.LanguageRepository;
import uz.agromon.tenant.store.repo.TenantNameRepository;
import uz.agromon.tenant.store.repo.TenantRepository;

import java.util.List;

@Repository
public class TenantNameStoreLogic implements TenantNameStore{
    @Autowired
    TenantNameRepository repository;

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    TenantRepository tenantRepository;
    @Override
    public TenantName create(TenantName tenantName) throws Exception{
        TenantJpo tenantJpo = tenantRepository.getByCode(tenantName.getTenantCode());
        if (tenantJpo == null) {
            throw new Exception("Tenant does not exist");
        }
        LanguageJpo languageJpo = languageRepository.existsByCode(tenantName.getLangCode());
        if (languageJpo == null){
            throw new Exception("Language does not exist");
        }
        TenantNameJpo jpo = new TenantNameJpo();
        jpo.setLangCode(languageJpo.getCode());
        jpo.setTenant(tenantJpo);
        return repository.save(jpo).toDomain();
    }

    @Override
    public List<TenantName> getAllNames() {
        return null;
    }
}
