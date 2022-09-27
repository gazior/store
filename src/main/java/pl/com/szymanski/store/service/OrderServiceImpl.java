package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final Cart cart;
    private final Order order;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    private final DeliveryRepository deliveryRepository;

    private final PaymentRepository paymentRepository;

    private final OrderTmp orderTmp;

    public OrderServiceImpl(Cart cart, Order order, OrderRepository orderRepository, UserRepository userRepository, AddressRepository addressRepository, DeliveryRepository deliveryRepository, PaymentRepository paymentRepository, OrderTmp orderTmp) {
        this.cart = cart;
        this.order = order;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.deliveryRepository = deliveryRepository;
        this.paymentRepository = paymentRepository;
        this.orderTmp = orderTmp;
    }

    public Long saveOrder(OrderDetails orderDetails) {
        addressRepository.save(orderTmp.getAddress());
        order.setOrderDetails(cart.getCartItems().stream().map(p -> {
            orderDetails.setQuantity(p.getQuantity());
            orderDetails.setProduct(p.getProduct());
            orderDetails.setSumPrice(p.getProduct().getPrice() * p.getQuantity());
            return orderDetails;
        }).collect(Collectors.toList()));
        order.setPayment(orderTmp.getPayment());
        order.setDelivery(orderTmp.getDelivery());
        order.setSumPrice(cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        order.setAddress(orderTmp.getAddress());
        order.setUser(userRepository.findUserById(1L));
        order.setPaymentMethod("cash");
        orderRepository.flush();
        orderRepository.save(order);
        cart.getCartItems().clear();

        System.out.println(orderTmp.getAddress().getId());
        System.out.println(orderTmp.getDelivery().getId());
        System.out.println(orderTmp.getPayment().getId());
        System.out.println(orderTmp.getDelivery().getName());
        System.out.println(orderTmp.getPayment().getName());

        return order.getId();

    }

    @Override
    public List<Order> findOrderByUserId(User user) {
        return orderRepository.findOrdersByUserIs(user);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findOrdersById(id);
    }

}
