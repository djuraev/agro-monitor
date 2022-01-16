package uz.agromon.user.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.config.exception.klass.ResourceNotFoundException;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.user.domain.Admin;
import uz.agromon.user.domain.ERole;
import uz.agromon.user.domain.User;
import uz.agromon.user.api.dto.UserLoginForm;
import uz.agromon.user.service.AdminService;
import uz.agromon.user.service.UserService;

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
}
