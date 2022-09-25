package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Address;
import pl.com.szymanski.store.domain.Order;
import pl.com.szymanski.store.domain.OrderDetails;
import pl.com.szymanski.store.domain.User;

import java.util.List;

@Service
public interface OrderService {

    void saveOrder(Address address, OrderDetails orderDetails);
    List<Order> findOrderByUserId(User user);
    Order findOrderById(Long id);

}
