package uz.agromon.mobile.dto.response;

import uz.agromon.mobile.dto.response.dto.RegionDto;

import java.util.ArrayList;
import java.util.List;

public class RegionResponse extends Response {
    List<RegionDto> regions;

    public RegionResponse() {
        regions = new ArrayList<>();
        result = true;
    }

    public RegionResponse(List<RegionDto> regions) {
        this.regions = regions;
    }

    public List<RegionDto> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionDto> regionDtos) {
        this.regions = regionDtos;
    }
}
