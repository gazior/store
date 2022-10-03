package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.szymanski.store.domain.PayU.PaymentPayU;

public interface PaymentPayURepository extends JpaRepository<PaymentPayU,Long> {

    PaymentPayU findByExtOrderIdIs(Long id);

    PaymentPayU findFirstByExtOrderId(String id);
}
