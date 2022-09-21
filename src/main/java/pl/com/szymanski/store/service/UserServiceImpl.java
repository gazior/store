package pl.com.szymanski.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Role;
import pl.com.szymanski.store.domain.User;
import pl.com.szymanski.store.repository.RoleRepository;
import pl.com.szymanski.store.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

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

    
    public User findByUserName(String userName) {
        return userrepository.findByUsername(userName);

    }


    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("CUSTOMER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userrepository.save(user);
    }
}
