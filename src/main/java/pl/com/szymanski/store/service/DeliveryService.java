package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Delivery;

import java.util.List;

@Service
public interface DeliveryService {

    List<Delivery> findAll();

    Delivery findByName(String name);
}
