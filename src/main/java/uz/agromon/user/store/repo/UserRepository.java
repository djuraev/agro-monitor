package uz.agromon.user.store.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import uz.agromon.user.store.jpo.UserJpo;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJpo, Integer>, QueryByExampleExecutor<UserJpo> {
    Optional<UserJpo> findByInsuranceNumber(String insuranceNumber);
    boolean existsByInsuranceNumber(String insuranceNumber);
    UserJpo findByDateOfBirthAndPhoneNumberAndDistrictSequence(String dob, String phone, Integer districtSeq);
    UserJpo findByDateOfBirthAndPhoneNumberAndInsuranceNumberAndDistrictSequence(String birthday, String phone, String insu, Integer districtSeq);

    @Query(value = "select *  from user u where u.tenant_id = ?1 and u.region_sequence=?2 and u.district_sequence=?3 and u.village_sequence=?4", nativeQuery = true)
    Page<UserJpo> getUsers(Integer tId, Integer rId, Integer dId, Integer vId, Pageable page);

    Page<UserJpo> getAllBy(UserJpo user, Pageable page);
}
