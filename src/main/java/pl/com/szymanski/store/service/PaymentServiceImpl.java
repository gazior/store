package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Delivery;
import pl.com.szymanski.store.domain.Payment;
import pl.com.szymanski.store.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findByName(String name) {
        return paymentRepository.findByName(name);
    }
}
