package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(){
        return "Sukces";
    }
}
