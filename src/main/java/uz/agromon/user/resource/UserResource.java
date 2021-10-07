package uz.agromon.user.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agromon.user.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class UserResource {
    @Autowired
    UserService userService;
}
