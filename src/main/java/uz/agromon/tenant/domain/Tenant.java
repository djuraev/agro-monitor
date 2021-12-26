package uz.agromon.tenant.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Tenant {
    Integer id;
    String country;
    String code;
    String capital;
    String coordinates;
    Set<TenantName> names;

    public Tenant(Integer id, String country, String code, Set<TenantName> names) {
        this.id = id;
        this.country = country;
        this.code = code;
        this.names = names;
    }

    public Tenant() {
        names = new HashSet<>();
    }

    public Set<TenantName> getNames() {
        return names;
    }

    public void setNames(Set<TenantName> names) {
        this.names = names;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
