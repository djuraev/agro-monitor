package uz.agromon.mobile.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoverViewResources {
    //
    @Value("${html-files.folder}")
    private String resourceFolder;

    @RequestMapping(value = "/htmlViews/Cover_en", method = RequestMethod.GET)
    public String getInsuranceEnglish() {
        //String fileName = pageName + ".html";
        return resourceFolder +"Cover_en.html";
    }

    @RequestMapping(value = "/htmlViews/Cover_ru", method = RequestMethod.GET)
    public String getInsuranceRussian() {
        //String fileName = pageName + ".html";
        return resourceFolder +"Cover_ru.html";
    }

    @RequestMapping(value = "/htmlViews/Cover_mn", method = RequestMethod.GET)
    public String getInsuranceMain() {
        //String fileName = pageName + ".html";
        return resourceFolder +"Cover_mn.html";
    }

    @RequestMapping(value = "/htmlViews/Cover_uz", method = RequestMethod.GET)
    public String getInsuranceUzbek() {
        //String fileName = pageName + ".html";
        return resourceFolder +"Cover_uz.html";
    }
}
