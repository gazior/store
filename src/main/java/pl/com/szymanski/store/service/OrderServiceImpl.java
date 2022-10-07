package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final Cart cart;
    private final Order order;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;


    private final OrderTmp orderTmp;

    public OrderServiceImpl(Cart cart, Order order, OrderRepository orderRepository, UserRepository userRepository, AddressRepository addressRepository, OrderTmp orderTmp) {
        this.cart = cart;
        this.order = order;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.orderTmp = orderTmp;
    }

    public Long saveOrder(CurrentUser currentUser, OrderDetails orderDetails) {
        addressRepository.save(orderTmp.getAddress());
        order.setOrderDetails(cart.getCartItems().stream().map(p -> new OrderDetails(p.getProduct(), p.getQuantity(), p.getQuantity() * p.getProduct().getPrice())).collect(Collectors.toList()));
        order.setPayment(orderTmp.getPayment());
        order.setDelivery(orderTmp.getDelivery());
        order.setSumPrice(cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        order.setAddress(orderTmp.getAddress());
        order.setUser(userRepository.findUserById(currentUser.getUser().getId()).get());
        order.setPaymentMethod("cash");
        orderRepository.flush();
        orderRepository.save(order);
        cart.getCartItems().clear();

        return order.getId();

    }

    @Override
    public Optional<List<Order>> findOrderByUserId(User user) {
        return Optional.ofNullable(orderRepository.findOrdersByUserIs(user));
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return Optional.ofNullable(orderRepository.findOrdersById(id));
    }

}
