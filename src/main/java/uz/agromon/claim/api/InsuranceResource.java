package uz.agromon.claim.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.claim.service.InsuranceService;

@RestController("/insurance")
public class InsuranceResource {
    @Autowired
    InsuranceService insuranceService;
}
