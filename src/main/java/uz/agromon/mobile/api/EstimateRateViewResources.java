package uz.agromon.mobile.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EstimateRateViewResources {
    @RequestMapping(value = "/htmlViews/EstimateRate_en", method = RequestMethod.GET)
    public String getInsuranceEnglish() {
        //String fileName = pageName + ".html";
        return "EstimateRate_en.html";
    }

    @RequestMapping(value = "/htmlViews/EstimateRate_ru", method = RequestMethod.GET)
    public String getInsuranceRussian() {
        //String fileName = pageName + ".html";
        return "EstimateRate_ru.html";
    }

    @RequestMapping(value = "/htmlViews/EstimateRate_mn", method = RequestMethod.GET)
    public String getInsuranceMain() {
        //String fileName = pageName + ".html";
        return "EstimateRate_mn.html";
    }

    @RequestMapping(value = "/htmlViews/EstimateRate_uz", method = RequestMethod.GET)
    public String getInsuranceUzbek() {
        //String fileName = pageName + ".html";
        return "EstimateRate_uz.html";
    }
}
