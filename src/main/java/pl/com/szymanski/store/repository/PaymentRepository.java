package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.szymanski.store.domain.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> findAll();

    Payment findByName(String name);
}
