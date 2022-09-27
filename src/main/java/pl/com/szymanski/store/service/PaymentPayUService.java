package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.PaymentPayU;

@Service
public interface PaymentPayUService {


    void save(PaymentPayU paymentPayU);

    PaymentPayU findByExtOrderIdIs(String id);
}
