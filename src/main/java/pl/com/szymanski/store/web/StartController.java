package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.Cart;
import pl.com.szymanski.store.repository.ProductRepository;

@Controller
public class StartController {

    @RequestMapping("/")
    public String start() {
        return "home";
    }

}
