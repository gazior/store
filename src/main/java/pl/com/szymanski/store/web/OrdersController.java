package pl.com.szymanski.store.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.service.*;

import java.util.List;
import java.util.Optional;

@Controller
public class OrdersController {

    private final Cart cart;
    private final OrderTmp orderTmp;
    private final OrderService orderService;
    private final UserService userService;
    private final DeliveryService deliveryService;
    private final PaymentService paymentService;
    private final PayuService payuService;

    private final OrderStatusService orderStatusService;


    public OrdersController(Cart cart, OrderTmp orderTmp, OrderService orderService, UserService userService, DeliveryService deliveryService, PaymentService paymentService, PayuService payuService, OrderStatusService orderStatusService) {
        this.cart = cart;
        this.orderTmp = orderTmp;
        this.orderService = orderService;
        this.userService = userService;
        this.deliveryService = deliveryService;
        this.paymentService = paymentService;
        this.payuService = payuService;
        this.orderStatusService = orderStatusService;
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
    public List<String> showVoivodeship() {
        return List.of("Mazowieckie", "Zachodniopomorskie", "Pomorskie", "Warmińsko-Mazurskie", "Podlaskie", "Lubelskie", "Łódzkie", "Wielkopolskie", "Lubuskie", "Dolnośląskie", "Opolskie", "Śląskie", "Małopolskie", "Podkarpackie", "Świętokrzyskie");
    }

    @GetMapping(value = "/orders")
    public String showOrders(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        Optional<List<Order>> listOrders = orderService.findOrderByUserId(userService.findByUserName(currentUser.getUsername()).get());
        model.addAttribute("listOrders", listOrders);
        return "orders";
    }

    @GetMapping(value = "/order")
    public String order(@AuthenticationPrincipal CurrentUser currentUser, OrderDetails orderDetails,Order order) {

        Long id = orderService.saveOrder(order,currentUser, orderDetails);

        Long payment = orderService.findOrderById(id).get().getPayment().getId();
        if (payment == 3) {
            return "redirect:/api/" + id;
        } else {
            return "redirect:/order/" + id;
        }
    }

    @GetMapping(value = "/order/{id}")
    public String showOrder(@AuthenticationPrincipal CurrentUser currentUser, @PathVariable Long id, Model model) {

        Optional<Order> order = orderService.findOrderById(id);
        if (order.isEmpty()) {
            return "err";
        } else if (order.get().getUser().getId().equals(currentUser.getUser().getId())) {
            model.addAttribute("order", order.get());
            if (order.get().getPayment().getName().equals("PayU")) {
                model.addAttribute("payment", payuService.ResponsePaymentPayU(id.toString()));
            }
            return "showorder";
        } else {
            return "err";
        }
    }

    @GetMapping(value = "order/step1")
    public String getStepOne(@AuthenticationPrincipal CurrentUser currentUser, Model model, Optional<User> user, Address address) {

        user = userService.findById(currentUser.getUser().getId());
        address.setEmail(user.get().getEmail());
        address.setFirstName(user.get().getFirstName());
        address.setLastName(user.get().getLastName());
        address.setEmail(user.get().getEmail());
        model.addAttribute("cart", cart.getCartItems());
        model.addAttribute("count", cart.sum());
        model.addAttribute("total", cart.total());
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
        model.addAttribute("count", cart.sum());
        model.addAttribute("total", cart.total());
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
        model.addAttribute("count", cart.sum());
        model.addAttribute("total", cart.total());
        model.addAttribute("payment", payment);
        return "order3step";
    }

    @PostMapping(value = "order/step3")
    public String setStepTwo(Payment payment) {
        orderTmp.setPayment(payment);
        return "redirect:/order";
    }

    @GetMapping(value = "/order/cancel/{id}")
    public String cancelOrder(@AuthenticationPrincipal CurrentUser currentUser, @PathVariable Long id, Model model, Order order) {

        if (orderService.findOrderById(id).isEmpty()) {
            return "err";
        } else {
            order = orderService.findOrderById(id).get();
            order.setStatusOrder(orderStatusService.findByDescription("Anulowane"));
            orderService.updateStatus(order);
            return "redirect:/orders";
        }

    }

}
