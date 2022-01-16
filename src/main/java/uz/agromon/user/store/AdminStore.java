package uz.agromon.user.store;

import uz.agromon.user.domain.Admin;

public interface AdminStore {
    Admin retrieve(String username, String password);
}
