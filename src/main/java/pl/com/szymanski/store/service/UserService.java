package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;

import pl.com.szymanski.store.domain.User;

@Service
public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

}
