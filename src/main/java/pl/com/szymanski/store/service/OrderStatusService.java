package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.StatusOrder;

@Service
public interface OrderStatusService {

    public StatusOrder findByDescription(String name);
}
