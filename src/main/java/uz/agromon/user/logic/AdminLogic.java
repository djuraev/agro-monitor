package uz.agromon.user.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.user.domain.Admin;
import uz.agromon.user.service.AdminService;
import uz.agromon.user.store.AdminStore;

@Service
public class AdminLogic implements AdminService {
    //
    @Autowired
    AdminStore adminStore;

    @Override
    public Admin login(String username, String password) {
        return adminStore.retrieve(username, password);
    }
}
