package com.example.learnspringbootsecurityjwt.config;

import com.example.learnspringbootsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

//        // Chỉ cho phép user đã đăng nhập mới được truy cập đường dẫn /admin/**
//        http.authorizeRequests().antMatchers("/admin/**").authenticated();
//
//        // Cấu hình remember me, thời gian là 1296000 giây
//        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);

        http.authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
                .antMatchers("/register","/login").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();

//        // Cấu hình cho Login Form.
//        http.authorizeRequests().and().formLogin()//
//                .loginProcessingUrl("/j_spring_security_login")//
//                .loginPage("/login")//
//                .defaultSuccessUrl("/admin")//
//                .failureUrl("/login?message=error")//
//                .usernameParameter("username")//
//                .passwordParameter("password")
//                // Cấu hình cho Logout Page.
//                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?message=logout");

    }
}
