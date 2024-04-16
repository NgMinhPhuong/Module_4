package com.codegym.practicesecurity.configuration.security;

import com.codegym.practicesecurity.service.IUserService;
import com.codegym.practicesecurity.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }




    protected void configure(HttpSecurity http) throws Exception {
        // Disable crsf cho đường dẫn /api/**
        http.csrf().ignoringRequestMatchers("/api/**");
        http.authorizeHttpRequests()
                .requestMatchers("/login","/error").permitAll()
                .requestMatchers("/home","/admin").authenticated()
     //           .anyRequest().authenticated()
                .and().csrf().disable()
                .formLogin(form -> {
                    form
                            .usernameParameter("tendangnhap")
                            .passwordParameter("matkhau")
                            .loginPage("/login")
                            .failureUrl("/login?error=true")
                            .defaultSuccessUrl("/admin");
                })
                .logout(logout -> {
                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/login");
                });
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http.cors();
    }
}