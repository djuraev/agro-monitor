package uz.agromon.tenant.store;

import uz.agromon.tenant.domain.ApiInfo;
import uz.agromon.tenant.store.jpo.ApiInfoJpo;

import java.util.List;

public interface ApiInfoStore {
    ApiInfo save(ApiInfo info);
    List<ApiInfo> retrieveAll();
    ApiInfo retrieve(String name);
}
