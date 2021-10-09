package uz.agromon.tenant.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.agromon.tenant.domain.TenantName;
import uz.agromon.tenant.store.TenantNameStore;

@RestController
@RequestMapping("/api/tenantName")
public class TenantNameResource {

    @Autowired
    TenantNameStore tenantNameStore;

    @PostMapping(value = "/name")
    TenantName addTenantName(@RequestBody TenantName tenantName) throws Exception{
        return tenantNameStore.create(tenantName);
    }

}
