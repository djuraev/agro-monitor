package uz.agromon.tenant.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.tenant.domain.ApiInfo;
import uz.agromon.tenant.store.jpo.ApiInfoJpo;
import uz.agromon.tenant.store.repo.ApiInfoRepository;

import java.util.List;

@Repository
public class ApiInfoStoreLogic implements ApiInfoStore{
    @Autowired
    ApiInfoRepository apiInfoRepository;

    @Override
    public ApiInfo save(ApiInfo info) {
        ApiInfoJpo jpo = new ApiInfoJpo(info);
        return apiInfoRepository.save(jpo).toDomain();
    }

    @Override
    public List<ApiInfo> retrieveAll() {
        List<ApiInfoJpo> jpos = apiInfoRepository.getAllBy();
        return ApiInfoJpo.toDomains(jpos);
    }

    @Override
    public ApiInfo retrieve(String name) {
        ApiInfoJpo jpo = apiInfoRepository.getByApiName(name);
        if (jpo == null) {
            throw new ResourceNotFoundException(ApiInfo.class, name.concat(": ApiInfo cannot be found."));
        }
        return jpo.toDomain();
    }

    @Override
    public ApiInfo retrieveByKey(String key) {
        //
        ApiInfoJpo jpo = apiInfoRepository.getByApiKey(key);
        if (jpo == null) {
            throw new ResourceNotFoundException(ApiInfo.class, key.concat(": ApiInfo cannot be found."));
        }
        return jpo.toDomain();
    }

    @Override
    public ApiInfo update(ApiInfo apiInfo) {
        //
        ApiInfoJpo jpo = apiInfoRepository.getByApiKey(apiInfo.getApiKey());
        if (jpo == null) {
            throw new ResourceNotFoundException(ApiInfo.class, apiInfo.getApiKey().concat(": ApiInfo cannot be found."));
        }
        jpo.setApiName(apiInfo.getApiName());
        jpo.setExpired(apiInfo.isExpired());
        jpo = apiInfoRepository.save(jpo);
        return jpo.toDomain();
    }


}
