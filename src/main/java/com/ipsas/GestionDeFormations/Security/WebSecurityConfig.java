package com.ipsas.GestionDeFormations.Security;

import com.ipsas.GestionDeFormations.Models.User;
import com.ipsas.GestionDeFormations.Repositories.UserRepository;
import com.ipsas.GestionDeFormations.Services.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserPrincipalDetailsService userPrincipalDetailsService;

    public WebSecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
                .authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/groupe/**").hasRole("ADMIN")
                .antMatchers("/matiere/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(PasswordEncoder());

        return daoAuthenticationProvider;
    }

}
