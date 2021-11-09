package uz.agromon.mobile.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.field.domain.Field;
import uz.agromon.field.service.FieldService;
import uz.agromon.metrics.domain.Crop;
import uz.agromon.metrics.service.CropService;
import uz.agromon.metrics.service.DistrictMetricService;
import uz.agromon.metrics.service.FieldMetricService;
import uz.agromon.mobile.dto.request.GraphViewRequest;
import uz.agromon.mobile.dto.request.LoginRequest;
import uz.agromon.mobile.dto.response.*;
import uz.agromon.mobile.service.MUserService;
import uz.agromon.tenant.domain.ApiInfo;
import uz.agromon.tenant.service.ApiInfoService;
import uz.agromon.user.domain.User;


import java.util.List;

@RestController
@RequestMapping("/api/mobile")
public class ResourceForMobile {

    @Autowired
    MUserService userService;

    @Autowired
    ApiInfoService apiInfoService;
    @Autowired
    FieldService fieldService;
    @Autowired
    CropService cropService;

    @PostMapping(value = "/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = userService.login(request.username, request.password);
        ApiInfo apiInfo = apiInfoService.retrieve("agromon");
        LoginResponse loginResponse = LoginResponse.build(user, apiInfo);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/demo")
    ResponseEntity<DemoResponse> getDemo() {
        ApiInfo apiInfo = apiInfoService.retrieve("demo");
        DemoResponse demoResponse = new DemoResponse(apiInfo.getApiKey());
        return ResponseEntity.ok(demoResponse);
    }

    @GetMapping(value = "/info")
    ResponseEntity<AboutResponse> getAboutInfo() {
        ApiInfo aboutInfo = apiInfoService.retrieve("about");
        AboutResponse aboutResponse = new AboutResponse(aboutInfo.getApiKey());
        return ResponseEntity.ok(aboutResponse);
    }

    @GetMapping(value = "/user/fields/{userId}")
    ResponseEntity<FieldsResponse> getUserFields(@PathVariable String userId) {
        List<Field> fields = fieldService.getFieldsOfUser(userId);
        return ResponseEntity.ok(new FieldsResponse(fields));
    }

    @GetMapping(value = "/crops")
    ResponseEntity<CropsResponse> getAllCrops() {
        List<Crop> crops = cropService.getAllCrops();
        CropsResponse response = new CropsResponse(crops);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/metrics")
    ResponseEntity<?> getGraphViewInfo(@RequestBody GraphViewRequest request) {

    }
}
