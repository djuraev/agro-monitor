package uz.agromon.user.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.store.jpo.AgroMonEntity;
import uz.agromon.tenant.store.jpo.DistrictJpo;
import uz.agromon.user.domain.ERole;
import uz.agromon.user.domain.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name="USER")
public class UserJpo extends AgroMonEntity {
    String name;
    String surname;
    String email;
    String password;
    @Column(unique = true)
    String insuranceNumber;
    Integer regionSequence;
    Integer districtSequence;
    Integer villageSequence;
    //Added after requirement
    String dateOfBirth;  //DD.MM.YYYY
    String phoneNumber;
    String extraInfo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "user_sequence"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleJpo> roles = new HashSet<>();

    public UserJpo(){
        //
    }

    public UserJpo(User user) {
        //
        BeanUtils.copyProperties(user, this);
    }

    public UserJpo(User user, Set<RoleJpo> roles) {
        //
        BeanUtils.copyProperties(user, this);
        this.setRoles(roles);
    }

    public User toDomain(){
        User user = new User();
        BeanUtils.copyProperties(this, user);
        Set<String> setOfRoles = new HashSet<>();
        for(RoleJpo roleJpo: this.roles) {
            setOfRoles.add(roleJpo.getName());
        }
        user.setRoles(setOfRoles);
        return user;
    }
    public static List<User> toDomains(List<UserJpo> jpos){
        return jpos.stream().map(UserJpo::toDomain).collect(Collectors.toList());
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

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Set<RoleJpo> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleJpo> roles) {
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
}
