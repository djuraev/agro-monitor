package uz.agromon.user.api.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agromon.config.exception.klass.AlreadyExistsException;
import uz.agromon.helper.APIPagesResponse;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.user.domain.User;
import uz.agromon.user.service.UserService;
import uz.agromon.user.store.jpo.UserJpo;

import java.util.ArrayList;
import java.util.Collections;
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

    @PostMapping("/user/dynamic/{page}/{count}")
    ResponseEntity<APIPagesResponse> dynamicUserRequest(@RequestBody User user, @PathVariable Integer page, @PathVariable Integer count) {
        Page<UserJpo> users = userService.findAll(user, page, count);
        users.getTotalPages();
        return ResponseBuilder.buildOk(users.getContent(), users.getTotalElements(), users.getNumber(), users.getTotalPages());
    }

    @PostMapping("/user/dynamic")
    ResponseEntity<APIPagesResponse> dynamicUserRequest(@RequestBody User user) {
        Page<UserJpo> users = userService.findAll(user);
        users.getTotalPages();
        List<UserJpo> jpos = new ArrayList<>(users.getContent());
        Collections.reverse(jpos);
        return ResponseBuilder.buildOk(jpos, users.getTotalElements(), users.getNumber(), users.getTotalPages());
    }

    @DeleteMapping("/user/{userId}")
    ResponseEntity<APIResponse> deleteUser(@PathVariable String userId) {
        userService.removeUser(userId);
        return ResponseBuilder.buildOk("User deleted Successfully");
    }
}
