package uz.agromon.mobile.service;

import uz.agromon.user.domain.User;

public interface MUserService {
    User login(String username, String password);
}
