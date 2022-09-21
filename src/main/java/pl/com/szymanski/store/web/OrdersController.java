package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @GetMapping(value = "orders")
    public String showOrders() {
        return "orders";
    }
}
