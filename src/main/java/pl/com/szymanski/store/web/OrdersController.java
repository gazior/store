package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.com.szymanski.store.domain.Address;
import pl.com.szymanski.store.domain.Cart;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.service.AddressService;
import pl.com.szymanski.store.service.OrderService;

import java.util.logging.Logger;

@Controller
public class OrdersController {

    private final Cart cart;
    private final OrderService orderService;
    private final AddressService addressService;


    public OrdersController(Cart cart, OrderService orderService, AddressService addressService) {
        this.cart = cart;
        this.orderService = orderService;
        this.addressService = addressService;
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
        model.addAttribute("address",new Address());
        return "order";
    }

    @PostMapping(value = "/order")
    public String saveDeliveryAddress(Address address){
        addressService.saveAddress(address);
        orderService.saveOrder(address);
        return "ordersuccess";
    }

}
