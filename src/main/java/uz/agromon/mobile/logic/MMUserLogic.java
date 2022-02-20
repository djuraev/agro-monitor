package uz.agromon.mobile.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.InvalidUserParameterException;
import uz.agromon.mobile.service.MUserService;
import uz.agromon.tenant.domain.District;
import uz.agromon.tenant.domain.Region;
import uz.agromon.tenant.store.DistrictStore;
import uz.agromon.tenant.store.RegionStore;
import uz.agromon.tenant.store.jpo.DistrictJpo;
import uz.agromon.tenant.store.jpo.RegionJpo;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.jpo.UserJpo;
import uz.agromon.user.store.repo.UserRepository;
import uz.agromon.util.PasswordUtil;

@Service
public class MMUserLogic implements MUserService {
    //
    @Autowired
    UserRepository userStore;

    @Autowired
    RegionStore regionStore;

    @Autowired
    DistrictStore districtStore;


    @Override
    public User login(String username, String password) {
        UserJpo jpo = userStore.findByInsuranceNumber(username)
                .orElse(null);
        if (jpo == null) {
            throw new InvalidUserParameterException("Invalid Username.");
        }
        if (!PasswordUtil.isValidPassword(password, jpo.getPassword())) {
            throw new InvalidUserParameterException("Invalid Password.");
        }
        Region region = regionStore.retrieve(jpo.getRegionSequence());
        District district = districtStore.retrieve(jpo.getDistrictSequence());

        User user = jpo.toDomain();
        user.setRegion(region.getName());
        user.setDistrict(district.getName());
        return user;
    }
}
