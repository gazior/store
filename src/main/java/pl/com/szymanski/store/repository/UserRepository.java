package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.szymanski.store.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
