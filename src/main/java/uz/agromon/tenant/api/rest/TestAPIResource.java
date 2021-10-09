package uz.agromon.tenant.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestAPIResource {

    @GetMapping
    String getLatestVersionDate(){
        return "Sat 09 OCT 2021";
    }
}
