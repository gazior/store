package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.service.AddressService;
import pl.com.szymanski.store.service.OrderService;
import pl.com.szymanski.store.service.UserService;

import java.util.List;

@Controller
public class OrdersController {

    private final Cart cart;
    private final OrderService orderService;
    private final AddressService addressService;
    private final UserService userService;


    public OrdersController(Cart cart, OrderService orderService, AddressService addressService, UserService userService) {
        this.cart = cart;
        this.orderService = orderService;
        this.addressService = addressService;
        this.userService = userService;
    }


    @GetMapping(value = "/orders")
    public String showOrders(Model model) {
        List<Order> listOrders = orderService.findOrderByUserId(userService.findByUserName("Mateusz"));
        model.addAttribute("listOrders", listOrders);
        return "orders";
    }

    @GetMapping(value = "/order")
    public String order(Model model, Address address, Order order) {
        model.addAttribute("cart", cart.getCartItems());
        model.addAttribute("count", cart.getCartItems().stream().mapToInt(CartItem::getQuantity).sum());
        model.addAttribute("total", cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        model.addAttribute("address", address);
        model.addAttribute("order", order);
        return "order";
    }

    @PostMapping(value = "/order")
    public String saveDeliveryAddress(Address address) {
        addressService.saveAddress(address);
        orderService.saveOrder(address, new OrderDetails());
        return "ordersuccess";
    }

    @GetMapping(value = "/order/{id}")
    public String showOrder(@PathVariable Long id, Model model) {
        orderService.findOrderById(id);
        model.addAttribute("order", orderService.findOrderById(id));
        return "showorder";
    }

}
