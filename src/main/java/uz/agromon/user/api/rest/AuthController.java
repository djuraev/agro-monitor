package uz.agromon.user.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.user.domain.Admin;
import uz.agromon.user.domain.ERole;
import uz.agromon.user.domain.User;
import uz.agromon.user.api.dto.UserLoginForm;
import uz.agromon.user.service.AdminService;
import uz.agromon.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/login")
    ResponseEntity<APIResponse> login(@RequestBody UserLoginForm loginForm) {
        Admin admin = adminService.login(loginForm.getUsername(), loginForm.getPassword());
        return ResponseBuilder.buildOk(admin);
    }

    @PostMapping(value = "/manager")
    ResponseEntity<APIResponse> createAdmin(@RequestBody Admin admin) throws AlreadyExistsException {
        admin = adminService.create(admin);
        return ResponseBuilder.buildOk(admin);
    }

    @GetMapping(value = "/managers")
    ResponseEntity<APIResponse> getAllManagers() {
        List<Admin> admins = adminService.getAllManagers();
        return ResponseBuilder.buildOk(admins);
    }

    @DeleteMapping(value = "/manager")
    ResponseEntity<APIResponse> deleteManager(@RequestBody String username) {
        adminService.delete(username);
        return ResponseBuilder.buildOk("Removed successfully");
    }
}
