package com.example.websecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class LoginSecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login","/").permitAll()
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**" ).hasRole("ADMIN")
                        .requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")

                        .anyRequest().authenticated()
                )
                        .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/dologin")
                                .defaultSuccessUrl("/dashboard")
                                .failureForwardUrl("/login?error=true")
                                .permitAll()
                        )
                .logout(form ->
                        form
                                .logoutUrl("/doLogout")
                                .logoutSuccessUrl("/login?logout=true")
                                .permitAll()
                );
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user1 = User.withUsername("amit")
                .password("{noop}12345")
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("sumit")
                   .password("{noop}12345")
                    .roles("MANAGER")
                .build();
        UserDetails user3 = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,user3);

    }
}
