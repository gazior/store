package pl.com.szymanski.store.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Buyer;
import pl.com.szymanski.store.domain.Payu;
import pl.com.szymanski.store.domain.Product1;

@Service
public interface PayuService<T> {

    ResponseEntity<T> RequestPayU(Payu payu, Buyer buyer, Product1 product1,Long id);

    String ResponsePaymentPayU(String id);
}
