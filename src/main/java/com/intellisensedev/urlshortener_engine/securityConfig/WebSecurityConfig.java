package com.intellisensedev.urlshortener_engine.securityConfig;

import com.intellisensedev.urlshortener_engine.securityConfig.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
    @Autowired
    private UserDetailsServiceImplementation userDetailsService;

//    @Autowired
    //private AuthenticationSuccessHandler successHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/user/login").permitAll()
                .loginProcessingUrl("/user/login/processing")
                .usernameParameter("app_username")
                .passwordParameter("app_password")
                .defaultSuccessUrl("/user/dashboard")
                .failureUrl("/loginFailed")
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessUrl("/logout").permitAll()
                .and()
                .csrf().disable();

    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {

        webSecurity.ignoring().antMatchers( "/","/user/register","/developer","/url/create/custom/**","/password/**", "/username/retrieve", "/resources/**", "/static/**", "/assets/**", "/fonts/**", "/css/**", "/js/**", "/img/**", "/images/**");

    }

}