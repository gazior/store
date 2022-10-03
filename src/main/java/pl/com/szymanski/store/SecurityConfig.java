package pl.com.szymanski.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ClientSettings;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import pl.com.szymanski.store.service.CustomAuthenticationFailureHandler;

import java.util.UUID;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    @Order(1)
//    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http)
//            throws Exception {
//        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
//        http
//                // Redirect to the login page when not authenticated from the
//                // authorization endpoint
//                .exceptionHandling((exceptions) -> exceptions
//                        .authenticationEntryPoint(
//                                new LoginUrlAuthenticationEntryPoint("/login1"))
//                );
//
//        return http.build();
//    }

    @Bean
    @Order(1)
    public SecurityFilterChain defaultSecurityFilterChain1(HttpSecurity http)
            throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/account/**").authenticated()
                .antMatchers("/orders/**").authenticated()
                .antMatchers("/order/**").authenticated()
                .and().formLogin().loginPage("/login").failureHandler(authenticationFailureHandler())//.failureForwardUrl("/login/error")
                .and().logout().logoutSuccessUrl("/");
//        http.authorizeRequests()
//                .antMatchers("/oauth_login")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login()
//                .loginPage("/oauth_login");
        return http.build();
    }
    @Bean
    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/cart/**").authenticated()
                .antMatchers("/account/**").authenticated()
                .antMatchers("/orders/**").authenticated()
                .and().oauth2Login().loginPage("/login")
                .and().logout().logoutSuccessUrl("/");
//        http.authorizeRequests()
//                .antMatchers("/oauth_login")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login()
//                .loginPage("/oauth_login");
        return http.build();
    }


//    @Bean
//
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
//            throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/cart/**").authenticated()
//                .antMatchers("/account/**").authenticated()
//                .antMatchers("/orders/**").authenticated()
//                //.and().formLogin().loginPage("/login")
//                .and().oauth2Login()
//                .and().logout().logoutSuccessUrl("/");
//        return http.build();
//    }

    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("829190185645-b21m1okcdneph59lrcgv7ldk4546sfcg.apps.googleusercontent.com")
                .clientSecret("{noop}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")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
                .redirectUri("http://127.0.0.1:8080/authorized")
                .scope(OidcScopes.OPENID)
                .scope("message.read")
                .scope("message.write")
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                .build();

        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
    @Bean
    public ProviderSettings providerSettings() {
        return ProviderSettings.builder().build();
    }


    @Bean
    public WebClient.Builder getWebClient()
    {
        return WebClient.builder();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}