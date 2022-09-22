package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.com.szymanski.store.domain.Cart;
import pl.com.szymanski.store.domain.Order;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.service.OrderService;
import pl.com.szymanski.store.service.OrderServiceImpl;

@Controller
public class OrdersController {

    private final Cart cart;
    private final OrderService orderService;


    public OrdersController(Cart cart, OrderService orderService) {
        this.cart = cart;
        this.orderService = orderService;
    }


    @GetMapping(value = "/orders")
    public String showOrders() {
        return "orders";
    }

    @GetMapping(value = "/order")
    public String order(Model model){
        Long count = cart.getAllProduct().stream().count();
        Double total = cart.getAllProduct().stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("cart", cart.getAllProduct());
        model.addAttribute("count", count);
        model.addAttribute("total", total);
        return "order";
    }

    @GetMapping(value = "/setorder")
    public String finalizeOrder(){
        orderService.saveOrder();
        return "ordersuccess";
    }
}
