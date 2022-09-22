package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.com.szymanski.store.domain.User;
import pl.com.szymanski.store.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")

    public String register(Model model) {
        User user = new User();
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
}
