package pl.com.szymanski.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/cart/**").authenticated()
                .antMatchers("/account/**").authenticated()
                .antMatchers("/orders/**").authenticated()
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/");
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}