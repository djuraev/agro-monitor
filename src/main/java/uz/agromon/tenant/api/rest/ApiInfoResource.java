package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.tenant.domain.ApiInfo;
import uz.agromon.tenant.service.ApiInfoService;

import java.util.List;


@RestController
@RequestMapping("/api-info")
public class ApiInfoResource {

    @Autowired
    ApiInfoService apiInfoService;

    @PostMapping("/api-info")
    ResponseEntity<APIResponse> createApiInfo(@RequestBody ApiInfo apiInfo) {
        ApiInfo ai = apiInfoService.create(apiInfo);
        return ResponseBuilder.buildOk(ai);
    }

    @GetMapping("/api-info")
    ResponseEntity<APIResponse> getAllApiInfos() {
        List<ApiInfo> apiInfoList = apiInfoService.retrieveAll();
        return ResponseBuilder.buildOk(apiInfoList);
    }

    @PutMapping("/api-info")
    ResponseEntity<APIResponse> updateApiInfo(@RequestBody ApiInfo apiInfo) {
        //
        ApiInfo info = apiInfoService.update(apiInfo);
        return ResponseBuilder.buildOk(info);
    }
}
