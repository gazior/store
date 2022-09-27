package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Delivery;
import pl.com.szymanski.store.repository.DeliveryRepository;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery findByName(String name) {
        return deliveryRepository.findDeliveryByName(name);
    }
}
