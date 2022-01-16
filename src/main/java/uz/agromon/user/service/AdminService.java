package uz.agromon.user.service;

import uz.agromon.user.domain.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
