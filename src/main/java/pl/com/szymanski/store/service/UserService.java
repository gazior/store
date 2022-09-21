package pl.com.szymanski.store.service;


import pl.com.szymanski.store.domain.User;

public interface UserService {

    User findByUserName(String username);
    void saveUser(User user);
}
