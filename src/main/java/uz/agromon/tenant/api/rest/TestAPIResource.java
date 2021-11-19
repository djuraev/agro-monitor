package uz.agromon.tenant.api.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.metrics.domain.Crop;

@RestController
@RequestMapping("/api/info")
public class TestAPIResource {

    @GetMapping("/info")
    String getLatestVersionDate(){
        return "FRIDAY 19 NOV 2021";
    }

    @GetMapping("/demo")
    ResponseEntity<APIResponse> getDemoVideo() {
        String videoUrl = "https://www.youtube.com/watch?v=_f-qkGJBPts";
        return ResponseBuilder.buildOk(videoUrl);
    }

    @GetMapping("/about")
    ResponseEntity<APIResponse> getInfoAboutApp() {
        String info = "https://play.google.com/store/apps/details?id=com.companyname.gnsportvideo&hl=en_US&gl=US";
        return ResponseBuilder.buildOk(info);
    }


}
