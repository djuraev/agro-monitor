package uz.agromon.user.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.user.domain.User;
import uz.agromon.user.api.dto.UserLoginForm;
import uz.agromon.user.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    ResponseEntity<APIResponse> login(@RequestBody UserLoginForm loginForm) {
        User user = userService.login(loginForm.getUsername(), loginForm.getPassword());
        return ResponseBuilder.buildOk(user);
    }
}
