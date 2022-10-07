package pl.com.szymanski.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.domain.Role;
import pl.com.szymanski.store.domain.User;
import pl.com.szymanski.store.repository.RoleRepository;
import pl.com.szymanski.store.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userrepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userrepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userrepository = userrepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<User> findByUserName(String userName) {
        return userrepository.findByUsername(userName);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByName("ROLE_CUSTOMER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userrepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userrepository.findById(id);
    }

}
