package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.szymanski.store.domain.Delivery;

import java.util.List;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

    List<Delivery> findAll();

    Delivery findDeliveryByName(String name);
}
