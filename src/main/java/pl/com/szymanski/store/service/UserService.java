package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;

import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByUserName(String name);
    void saveUser(User user);

    Optional<User> findById(Long id);


}
