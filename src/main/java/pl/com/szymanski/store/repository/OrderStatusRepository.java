package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.szymanski.store.domain.StatusOrder;

@Repository
public interface OrderStatusRepository extends JpaRepository<StatusOrder,Long> {

    StatusOrder findByDescription(String name);
}
