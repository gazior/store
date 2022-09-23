package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.com.szymanski.store.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {


}
