package pl.com.szymanski.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Cart;
import pl.com.szymanski.store.domain.Order;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    private final Cart cart;
    private final Order order;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(Cart cart, Order order, OrderRepository orderRepository) {
        this.cart = cart;
        this.order = order;
        this.orderRepository = orderRepository;
    }

    public void saveOrder(){
        order.setProducts(cart.getAllProduct());
        order.setSumPrice(cart.getAllProduct().stream().mapToDouble(Product::getPrice).sum());
        orderRepository.save(order);
    }
}
