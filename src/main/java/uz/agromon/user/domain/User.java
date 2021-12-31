package uz.agromon.user.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.Set;


@AllArgsConstructor
public class User {
    private Integer sequence;
    private Integer tenantId;
    private String country;
    private String name;
    private String surname;
    private String insuranceNumber;
    private String email;
    private String password;
    private Integer regionSequence;
    private String region;
    private Integer districtSequence;
    private String district;
    private Integer villageSequence;
    private String village;
    private Set<String> roles;
    //Added after requirement
    String dateOfBirth;  //DD.MM.YYYY
    String phoneNumber;
    String extraInfo;

    public User() {
    }

    public static User getEmptyInstance() {
        return new User();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRegionSequence() {
        return regionSequence;
    }

    public void setRegionSequence(Integer regionSequence) {
        this.regionSequence = regionSequence;
    }

    public Integer getDistrictSequence() {
        return districtSequence;
    }

    public void setDistrictSequence(Integer districtSequence) {
        this.districtSequence = districtSequence;
    }

    public Integer getVillageSequence() {
        return villageSequence;
    }

    public void setVillageSequence(Integer villageSequence) {
        this.villageSequence = villageSequence;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }
}
