package uz.agromon.user.store.jpo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import uz.agromon.tenant.store.jpo.AgroMonEntity;
import uz.agromon.user.domain.Admin;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@Entity
@Table(name="ADMIN")
public class AdminJpo extends AgroMonEntity {
    String name;
    String surname;
    String username;
    String password;
    AdminType adminType;

    public AdminJpo() {
    }

    public AdminJpo(String name, String surname, String username, String password, AdminType adminType) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.adminType = adminType;
    }

    public AdminJpo(Admin admin) {
        //
        BeanUtils.copyProperties(admin, this);
    }

    public Admin toDomain() {
        Admin admin = new Admin();
        BeanUtils.copyProperties(this, admin);
        return admin;
    }

    public static List<Admin> toDomains(List<AdminJpo> admins) {
        return admins.stream().map(AdminJpo::toDomain).collect(Collectors.toList());
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminType getAdminType() {
        return adminType;
    }

    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }
}
