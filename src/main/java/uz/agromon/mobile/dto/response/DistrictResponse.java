package uz.agromon.mobile.dto.response;

import uz.agromon.mobile.dto.response.dto.DistrictDto;

import java.util.ArrayList;
import java.util.List;

public class DistrictResponse extends Response {
    private List<DistrictDto> districts;

    public DistrictResponse() {
        districts = new ArrayList<>();
        result = true;
    }

    public DistrictResponse(List<DistrictDto> districts) {
        this.districts = districts;
    }

    public List<DistrictDto> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictDto> districtDtos) {
        this.districts = districtDtos;
    }
}
