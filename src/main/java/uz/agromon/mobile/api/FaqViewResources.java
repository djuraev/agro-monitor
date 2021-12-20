package uz.agromon.mobile.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FaqViewResources {
    @RequestMapping(value = "/htmlViews/Faq_en", method = RequestMethod.GET)
    public String getInsuranceEnglish() {
        //String fileName = pageName + ".html";
        return "Faq_en.html";
    }

    @RequestMapping(value = "/htmlViews/Faq_ru", method = RequestMethod.GET)
    public String getInsuranceRussian() {
        //String fileName = pageName + ".html";
        return "Faq_ru.html";
    }

    @RequestMapping(value = "/htmlViews/Faq_mn", method = RequestMethod.GET)
    public String getInsuranceMain() {
        //String fileName = pageName + ".html";
        return "Faq_mn.html";
    }

    @RequestMapping(value = "/htmlViews/Faq_uz", method = RequestMethod.GET)
    public String getInsuranceUzbek() {
        //String fileName = pageName + ".html";
        return "Faq_uz.html";
    }
}
