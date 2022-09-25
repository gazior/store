package pl.com.szymanski.store.web;

import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

//    @PostMapping(value = "/login")
//    @ResponseBody
//    public String login(){
//        return "Sukces";
//    }

    @GetMapping(value = "/login1")
    @ResponseBody
    public String log(){
        return "logo";
    }

}
