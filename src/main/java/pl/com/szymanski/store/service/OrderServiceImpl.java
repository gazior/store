package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.repository.OrderRepository;
import pl.com.szymanski.store.repository.UserRepository;

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

    public void saveOrder(Address address) {
        order.setProducts(cart.getAllProduct());
        order.setSumPrice(cart.getAllProduct().stream().mapToDouble(Product::getPrice).sum());
        order.setAddress(address);
        order.setUser(userRepository.findUserById(1L));
        order.setPaymentMethod("cash");
        orderRepository.saveAndFlush(order);
    }
}
