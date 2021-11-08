package uz.agromon.tenant.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.tenant.domain.ApiInfo;
import uz.agromon.tenant.service.ApiInfoService;
import uz.agromon.tenant.store.ApiInfoStore;

import java.util.List;

@Service
public class ApiInfoLogic implements ApiInfoService {
    @Autowired
    ApiInfoStore apiInfoStore;

    @Override
    public ApiInfo create(ApiInfo info) {
        return apiInfoStore.save(info);
    }

    @Override
    public ApiInfo retrieve(String name) {
        return apiInfoStore.retrieve(name);
    }

    @Override
    public List<ApiInfo> retrieveAll() {
        return apiInfoStore.retrieveAll();
    }
}
