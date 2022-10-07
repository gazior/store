package pl.com.szymanski.store.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.User;
import pl.com.szymanski.store.service.CurrentUser;
import pl.com.szymanski.store.service.UserService;

@Controller
public class AccountController {


    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/account")
    public String account(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("user", userService.findById(currentUser.getUser().getId()));
        return "account";
    }

    @GetMapping(value = "/account/pp")
    public String password() {
        return "password";
    }

    @PostMapping(value = "/account/pp")
    public String changePassword(@AuthenticationPrincipal CurrentUser currentUser, @RequestParam String newpassword, String confirmnewpassword, User user) {

        user = currentUser.getUser();

        if (newpassword.equals(confirmnewpassword)) {

            user.setPassword(newpassword);
            userService.saveUser(user);
            return "redirect:/account";
        }
        return "err";
    }

}
