package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.agromon.tenant.domain.Language;
import uz.agromon.tenant.service.LanguageService;
import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageResource {

    @Autowired
    LanguageService languageService;

    @PostMapping(value = "/language")
    Language createLanguage(@RequestBody Language language){
        return languageService.create(language);
    }

    @GetMapping(value = "/languages")
    List<Language> getAllLanguages() {
        return languageService.retrieveAll();
    }
}
