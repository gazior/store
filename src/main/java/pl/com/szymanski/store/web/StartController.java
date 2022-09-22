package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.Cart;
import pl.com.szymanski.store.repository.ProductRepository;

@Controller
public class StartController {

    private final Cart cart;
    private final ProductRepository productRepository;

    public StartController(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }


    @RequestMapping("/")
    public String start() {
        return "home";
    }


    @RequestMapping("/account")
    public String user() {
        return "account";
    }
}
