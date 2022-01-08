package uz.agromon.user.store.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.agromon.user.store.jpo.UserJpo;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJpo, Integer>{
    UserJpo findByEmail(String email);
    Optional<UserJpo> findByInsuranceNumber(String insuranceNumber);
    boolean existsByInsuranceNumber(String insuranceNumber);
    UserJpo findByDateOfBirthAndPhoneNumberAndDistrictSequence(String dob, String phone, Integer districtSeq);
    UserJpo findByDateOfBirthAndPhoneNumberAndInsuranceNumberAndDistrictSequence(String birthday, String phone, String insu, Integer districtSeq);
    //Page<UserJpo> findAllBy
}
