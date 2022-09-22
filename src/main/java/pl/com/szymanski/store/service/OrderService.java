package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Order;

@Service
public interface OrderService {

     void saveOrder();
}
