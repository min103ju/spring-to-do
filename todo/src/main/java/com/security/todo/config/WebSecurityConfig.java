package com.security.todo.config;

import com.security.todo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /* 로그인 실패 Handler -> SigninFailureHandler를 Component로 등록하여 사용 중 */
    private final AuthenticationFailureHandler authenticationFailureHandler;

    /* Password Encoder Bean 등록 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .csrf()
//                .disable()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .authorizeRequests()
//                .anyRequest().permitAll()
                .antMatchers("/", "/login", "/signup", "/user").permitAll()
                .antMatchers("/**").hasRole("USER")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .failureForwardUrl("/error")
                .defaultSuccessUrl("/todoList")
                .failureHandler(authenticationFailureHandler)
            .and()
                .logout()
                .logoutSuccessUrl("/");

    }

}
