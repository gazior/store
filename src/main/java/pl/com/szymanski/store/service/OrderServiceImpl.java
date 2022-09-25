package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.repository.OrderRepository;
import pl.com.szymanski.store.repository.ProductRepository;
import pl.com.szymanski.store.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final Cart cart;
    private final Order order;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(Cart cart, Order order, OrderRepository orderRepository, UserRepository userRepository) {
        this.cart = cart;
        this.order = order;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public void saveOrder(Address address, OrderDetails orderDetails) {
        order.setOrderDetails(cart.getCartItems().stream().map(p -> {
            orderDetails.setQuantity(p.getQuantity());
            orderDetails.setProduct(p.getProduct());
            orderDetails.setSumPrice(p.getProduct().getPrice() * p.getQuantity());
            return orderDetails;
        }).collect(Collectors.toList()));
        order.setSumPrice(cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        order.setAddress(address);
        order.setUser(userRepository.findUserById(1L));
        order.setPaymentMethod("cash");
        orderRepository.flush();
        orderRepository.save(order);
        cart.getCartItems().clear();

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
