package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.PayU.PaymentPayU;
import pl.com.szymanski.store.repository.PaymentPayURepository;

@Service
public class PaymentPayUServiceImpl implements PaymentPayUService {

    private final PaymentPayURepository paymentPayURepository;

    public PaymentPayUServiceImpl(PaymentPayURepository paymentPayURepository) {
        this.paymentPayURepository = paymentPayURepository;
    }

    public void save(PaymentPayU paymentPayU){
        paymentPayURepository.save(paymentPayU);
    }

    @Override
    public PaymentPayU findByExtOrderIdIs(String id) {
       return paymentPayURepository.findFirstByExtOrderId(id);
    }
}
