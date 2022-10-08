package pl.com.szymanski.store.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.StatusOrder;
import pl.com.szymanski.store.repository.OrderStatusRepository;

@Service
public class OrderStatusServiceImpl implements OrderStatusService{

    private final OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }


    @Override
    public StatusOrder findByDescription(String name) {
        return orderStatusRepository.findByDescription(name);
    }
}
