package uz.agromon.tenant.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tenant {
    Integer id;
    String country;
    String code;
    List<TenantName> names;

    public Tenant(Integer id, String country, String code, List<TenantName> names) {
        this.id = id;
        this.country = country;
        this.code = code;
        this.names = names;
    }

    public Tenant() {
        names = new ArrayList<>();
    }

    public List<TenantName> getNames() {
        return names;
    }

    public void setNames(List<TenantName> names) {
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
}
