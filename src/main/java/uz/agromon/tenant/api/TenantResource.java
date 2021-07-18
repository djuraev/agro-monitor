package uz.agromon.tenant.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.service.TenantService;

import java.util.List;

@RestController
@RequestMapping("/api/tenant")
public class TenantResource {
    @Autowired
    TenantService tenantService;

    @GetMapping(value = "/tenants")
    List<Tenant> getAllTenants(){
        return tenantService.getAllTenants();
    }
}
