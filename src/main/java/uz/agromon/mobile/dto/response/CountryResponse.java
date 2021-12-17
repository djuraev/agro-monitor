package uz.agromon.mobile.dto.response;

import uz.agromon.mobile.dto.response.dto.CountryDto;

import java.util.ArrayList;
import java.util.List;

public class CountryResponse extends Response {
    //
    private List<CountryDto> countries;

    public CountryResponse() {
        //
        countries = new ArrayList<>();
        result = true;
    }

    public CountryResponse(List<CountryDto> countries) {
        this.countries = countries;
    }

    public List<CountryDto> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDto> countries) {
        this.countries = countries;
    }
}
