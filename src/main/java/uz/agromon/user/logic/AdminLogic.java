package uz.agromon.user.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.store.TenantStore;
import uz.agromon.user.domain.Admin;
import uz.agromon.user.service.AdminService;
import uz.agromon.user.store.AdminStore;

import java.util.List;

@Service
public class AdminLogic implements AdminService {
    //
    @Autowired
    AdminStore adminStore;
    @Autowired
    TenantStore tenantStore;

    @Override
    public Admin login(String username, String password) {
        return adminStore.retrieve(username, password);
    }

    @Override
    public Admin create(Admin admin) throws AlreadyExistsException {
        return adminStore.save(admin);
    }

    @Override
    public void delete(String username) {
        adminStore.delete(username);
    }

    @Override
    public List<Admin> getAllManagers() {
        List<Admin> admins = adminStore.getAll();
        for (Admin admin: admins) {
            Tenant tenant = tenantStore.retrieve(admin.getTenantId());
            admin.setCountry(tenant.getCountry());
        }
        return admins;
    }
}
