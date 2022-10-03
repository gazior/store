package pl.com.szymanski.store.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.szymanski.store.domain.User;
import pl.com.szymanski.store.service.UserService;

import java.util.Optional;

@Controller
public class RegisterController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final User user;

    public RegisterController(UserService userService, BCryptPasswordEncoder passwordEncoder, User user) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.user = user;
    }

    @GetMapping(value = "/login")

    public String register(Model model) {
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping(value = "/register")
    public String showCustomer(Model model, User user) {
        userService.saveUser(user);
        String success = "success";
        model.addAttribute("success", success);
        return "registersuccess";
    }

    @RequestMapping(value = "login/error")
    public String badCredential(Model model, String username, String password) {

        Optional<User> user = Optional.ofNullable(userService.findByUserName(username));

        if (user.isEmpty()) {
            model.addAttribute("badCredential", "Podana nazwa użytkownika lub email są nieprawidłowe.");
            return "loginFailed";
        } else if (!user.get().getPassword().equals(passwordEncoder.encode(password))) {
            model.addAttribute("badCredential", "Błędne hasło");

            return "loginFailed";
        }
        return "login";
    }
}
