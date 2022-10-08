package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Order;
import pl.com.szymanski.store.domain.OrderDetails;
import pl.com.szymanski.store.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {

    Long saveOrder(Order order,CurrentUser currentUser,OrderDetails orderDetails);
    Optional<List<Order>> findOrderByUserId(User user);
    Optional<Order> findOrderById(Long id);
    void updateStatus(Order order);

}