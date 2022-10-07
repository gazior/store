package pl.com.szymanski.store.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.com.szymanski.store.domain.User;
import pl.com.szymanski.store.service.CurrentUser;
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


        if (userService.findByUserName(user.getUsername()).isEmpty()) {
            userService.saveUser(user);
            String success = "success";
            model.addAttribute("success", success);
            return "registersuccess";
        }
        model.addAttribute("message", "Podany użytkownik istnieje w bazie danych");
        return "err";
    }

    @RequestMapping(value = "login/error")
    public String badCredential(Model model, String username, String password) {

        Optional<User> user = userService.findByUserName(username);

        if (user.isEmpty()) {
            model.addAttribute("badCredential", "Podana nazwa użytkownika lub hasło są nieprawidłowe.");
            return "loginFailed";
        }

        return "login";
    }

}
