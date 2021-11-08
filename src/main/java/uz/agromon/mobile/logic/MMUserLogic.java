package uz.agromon.mobile.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.InvalidUserParameterException;
import uz.agromon.mobile.service.MUserService;
import uz.agromon.user.domain.User;
import uz.agromon.user.store.jpo.UserJpo;
import uz.agromon.user.store.repo.UserRepository;
import uz.agromon.util.PasswordUtil;

@Service
public class MMUserLogic implements MUserService {
    //
    @Autowired
    UserRepository userStore;


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
        return jpo.toDomain();
    }
}
