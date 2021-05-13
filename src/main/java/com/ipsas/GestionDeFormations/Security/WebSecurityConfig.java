package com.ipsas.GestionDeFormations.Security;

import com.ipsas.GestionDeFormations.Enums.Role;
import com.ipsas.GestionDeFormations.Jwt.JwtFilter;
import com.ipsas.GestionDeFormations.Services.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserPrincipalDetailsService userPrincipalDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

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
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/users/**").hasAnyRole(Role.ADMIN.name())
                .mvcMatchers("/groupes/**").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated();

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

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
