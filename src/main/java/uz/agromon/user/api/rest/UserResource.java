package uz.agromon.user.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.user.domain.User;
import uz.agromon.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    UserService userService;


    @PostMapping(value = "/user")
    ResponseEntity<APIResponse> createUser(@RequestBody User user) throws AlreadyExistsException {
        User result = userService.create(user);
        return ResponseBuilder.buildOk(result);
    }

    @GetMapping(value = "/users")
    ResponseEntity<APIResponse> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseBuilder.buildOk(users);
    }

    @PutMapping(value = "/user")
    ResponseEntity<APIResponse> updateUser(@RequestBody User user) {
        User result = userService.update(user);
        return ResponseBuilder.buildOk(result);
    }

    @GetMapping(value = "/user/{insuNumber}")
    ResponseEntity<APIResponse> getUserInfo(@PathVariable String insuNumber) {
        User user = userService.getByInsuranceNumber(insuNumber);
        return ResponseBuilder.buildOk(user);
    }
}
