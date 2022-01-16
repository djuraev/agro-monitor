package uz.agromon.user.store;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.jpo.UserJpo;

import java.util.List;

public interface UserStore {
    User create(User user);
    User retrieve(Integer sequence);
    List<User> retrieve();
    User update(User user);
    User retrieve(String insuranceNumber);
    boolean existsByInsurance(String insuranceNumber);
    User retrieve(String birthday, String phone, Integer districtId);
    User retrieve(String birthday, String phone, String insuNumber, Integer districtId);
    Page<User> getUserDynamicQuery(Integer tId, Integer rId, Integer dId, Integer vId, Pageable page);
    Page<UserJpo> getAll(User user, Pageable page);
}
