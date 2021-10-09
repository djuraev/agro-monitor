package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.service.DistrictService;

@RestController
@RequestMapping("/api/tenant/district")
public class DistrictResource {

    @Autowired
    DistrictService districtService;

    @PostMapping(value = "/district")
    District createDistrict (@RequestBody District district) {
        return districtService.create(district);
    }
}
