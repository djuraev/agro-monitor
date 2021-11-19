package uz.agromon.tenant.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.tenant.domain.Tenant;
import uz.agromon.tenant.domain.TenantName;
import uz.agromon.tenant.service.TenantService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/tenant")
public class TenantResource {
    @Autowired
    TenantService tenantService;

    @GetMapping(value = "/tenants")
    ResponseEntity<APIResponse> getAllTenants(){
        List<Tenant> tenants = tenantService.getAllTenants();
        return ResponseBuilder.buildOk(tenants);
    }

    @PostMapping(value = "/tenants")
    ResponseEntity<APIResponse> create(@RequestBody Tenant tenant) {
        Tenant newTenant = tenantService.create(tenant);
        return ResponseBuilder.buildOk(newTenant);
    }

    @PostMapping(value = "/language/{tenant_code}")
    ResponseEntity<APIResponse> addNameToTenant(@PathVariable String tenant_code, @RequestBody TenantName tenantName) {
        Tenant tenant = tenantService.update(tenant_code, tenantName);
        return ResponseBuilder.buildOk(tenant);
    }

    @GetMapping(value = "tenant/{tenantCode}")
    ResponseEntity<APIResponse> getTenant(@PathVariable String tenantCode) {
        Tenant tenant = tenantService.retrieve(tenantCode);
        return ResponseBuilder.buildOk(tenant);
    }


}
