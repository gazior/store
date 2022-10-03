package pl.com.szymanski.store.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.User;
import pl.com.szymanski.store.service.UserService;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public LoginController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

}
