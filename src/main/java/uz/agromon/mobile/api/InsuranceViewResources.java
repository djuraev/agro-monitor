package uz.agromon.mobile.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InsuranceViewResources {
    @RequestMapping(value = "/htmlViews/Insurance_en", method = RequestMethod.GET)
    public String getInsuranceEnglish() {
        //String fileName = pageName + ".html";
        return "Insurance_en.html";
    }

    @RequestMapping(value = "/htmlViews/Insurance_ru", method = RequestMethod.GET)
    public String getInsuranceRussian() {
        //String fileName = pageName + ".html";
        return "Insurance_ru.html";
    }

    @RequestMapping(value = "/htmlViews/Insurance_mn", method = RequestMethod.GET)
    public String getInsuranceMain() {
        //String fileName = pageName + ".html";
        return "Insurance_mn.html";
    }

    @RequestMapping(value = "/htmlViews/Insurance_uz", method = RequestMethod.GET)
    public String getInsuranceUzbek() {
        //String fileName = pageName + ".html";
        return "Insurance_uz.html";
    }
}
