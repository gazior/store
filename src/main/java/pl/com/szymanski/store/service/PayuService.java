package pl.com.szymanski.store.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PayuService<T> {

    ResponseEntity<T> RequestPayU(Long id);

    String ResponsePaymentPayU(String id);
}
