package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.service.*;

import java.util.List;

@Controller
public class OrdersController {

    private final Cart cart;
    private final OrderTmp orderTmp;
    private final OrderService orderService;
    private final AddressService addressService;
    private final UserService userService;
    private final DeliveryService deliveryService;
    private final PaymentService paymentService;
    private final PayuService payuService;


    public OrdersController(Cart cart, OrderTmp orderTmp, OrderService orderService, AddressService addressService, UserService userService, DeliveryService deliveryService, PaymentService paymentService, PayuService payuService) {
        this.cart = cart;
        this.orderTmp = orderTmp;
        this.orderService = orderService;
        this.addressService = addressService;
        this.userService = userService;
        this.deliveryService = deliveryService;
        this.paymentService = paymentService;
        this.payuService = payuService;
    }

    @ModelAttribute("deliveries")
    public List<Delivery> deliveries() {
        return deliveryService.findAll();
    }

    @ModelAttribute("payments")
    public List<Payment> payments() {
        return paymentService.findAll();
    }

    @ModelAttribute("voivodeship")
    public List<String> showVoivodeship(){
        return List.of("Mazowieckie","Zachodniopomorskie","Pomorskie","Warmińsko-Mazurskie","Podlaskie","Lubelskie","Łódzkie","Wielkopolskie","Lubuskie","Dolnośląskie","Opolskie","Śląskie","Małopolskie","Podkarpackie","Świętokrzyskie");
    }
//    @ModelAttribute("address")
//    public Address returnAddress(){
//        return orderTmp.getAddress();
//    }

    @GetMapping(value = "/orders")
    public String showOrders(Model model) {
        List<Order> listOrders = orderService.findOrderByUserId(userService.findByUserName("Mateusz"));
        model.addAttribute("listOrders", listOrders);
        return "orders";
    }

    @GetMapping(value = "/order")
    public String order(OrderDetails orderDetails) {
        Long id = orderService.saveOrder(orderDetails);
        return "redirect:/api/" + id;
    }

    @PostMapping(value = "/order")
    public String saveDeliveryAddress(OrderDetails orderDetails) {

        Long id = orderService.saveOrder(orderDetails);
        return "redirect:/api/" + id;
    }

    @GetMapping(value = "/order/{id}")
    public String showOrder(@PathVariable Long id, Model model) {
        model.addAttribute("payment",payuService.ResponsePaymentPayU(id.toString()));
        model.addAttribute("order", orderService.findOrderById(id));
        return "showorder";
    }

    @GetMapping(value = "order/step1")
    public String getStepOne(Model model, Address address) {
        model.addAttribute("cart", cart.getCartItems());
        model.addAttribute("count", cart.getCartItems().stream().mapToInt(CartItem::getQuantity).sum());
        model.addAttribute("total", cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        model.addAttribute("address", address);
        return "order1step";
    }

    @PostMapping(value = "order/step1")
    public String setStepOne(Address address) {
        orderTmp.setAddress(address);
        return "redirect:/order/step2";
    }

    @GetMapping(value = "order/step2")
    public String getStepTwo(Model model, Delivery delivery) {
        model.addAttribute("cart", cart.getCartItems());
        model.addAttribute("count", cart.getCartItems().stream().mapToInt(CartItem::getQuantity).sum());
        model.addAttribute("total", cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        model.addAttribute("delivery", delivery);
        return "order2step";
    }

    @PostMapping(value = "order/step2")
    public String setStepTwo(Delivery delivery) {
        orderTmp.setDelivery(delivery);
        return "redirect:/order/step3";
    }

    @GetMapping(value = "order/step3")
    public String getStepThree(Model model, Payment payment) {
        model.addAttribute("cart", cart.getCartItems());
        model.addAttribute("count", cart.getCartItems().stream().mapToInt(CartItem::getQuantity).sum());
        model.addAttribute("total", cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        model.addAttribute("payment", payment);
        return "order3step";
    }

    @PostMapping(value = "order/step3")
    public String setStepTwo(Payment payment) {
        orderTmp.setPayment(payment);
        return "redirect:/order";
    }

}
