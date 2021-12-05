package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.DistrictName;
import uz.agromon.tenant.domain.cdo.DistrictCdo;
import uz.agromon.tenant.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("/api/tenant/district")
public class DistrictResource {

    @Autowired
    DistrictService districtService;

    @PostMapping(value = "/district")
    District createDistrict (@RequestBody District district) {
        return districtService.create(district);
    }

    @GetMapping(value = "/districts/{regionSequence}")
    ResponseEntity<APIResponse> getRegionDistricts(@PathVariable String regionSequence) {
        List<District> districts = districtService.getDistrictsOfRegion(regionSequence);
        return ResponseBuilder.buildOk(districts);
    }

    @GetMapping(value = "/districts/{regionSequence}/{langCode}")
    List<DistrictCdo> getRegionDistricts(@PathVariable String regionSequence, @PathVariable String langCode) {
        return districtService.getDistrictOfRegion(regionSequence, langCode);
    }

    @PostMapping(value = "/district/{districtSequence}")
    District addName(@PathVariable String  districtSequence, @RequestBody DistrictName name) {
        return districtService.addName(districtSequence, name);
    }

}
