package pl.com.szymanski.store.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Delivery;
import pl.com.szymanski.store.domain.Payment;

import java.util.List;

@Service
public interface PaymentService {


    List<Payment> findAll();

    Payment findByName(String name);


}
