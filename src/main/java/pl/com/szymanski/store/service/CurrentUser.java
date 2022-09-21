package pl.com.szymanski.store.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;

public class CurrentUser extends User {

    private final pl.com.szymanski.store.domain.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.com.szymanski.store.domain.User user) {
        super(username,password,authorities);
        this.user = user;

    }


    public pl.com.szymanski.store.domain.User getUser() {
        return user;
    }
}
