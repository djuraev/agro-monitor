package uz.agromon.tenant.service;

import uz.agromon.tenant.domain.ApiInfo;

import java.util.List;


public interface ApiInfoService {
    ApiInfo create(ApiInfo info);
    ApiInfo retrieve(String name);
    List<ApiInfo> retrieveAll();
}
