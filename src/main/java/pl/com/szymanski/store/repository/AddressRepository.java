package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.szymanski.store.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {


}
