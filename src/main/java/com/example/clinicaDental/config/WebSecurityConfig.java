package com.example.clinicaDental.config;

import com.example.clinicaDental.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().authorizeRequests()
                .antMatchers("/user/**","/patients/**","/dentists/**","/appointments/**").permitAll()
                .antMatchers("/index.html").hasRole("USER")
                .antMatchers("/formDentist.html").hasRole("ADMIN")
                .antMatchers("/formPatient.html").hasRole("ADMIN")
                .antMatchers("/formAppointment.html").hasRole("USER")
                .antMatchers("/listDentists.html").hasRole("ADMIN")
                .antMatchers("/listPatients.html").hasRole("ADMIN")
                .antMatchers("/listAppointments.html").hasRole("USER")
                .anyRequest().authenticated()
                // no me toma el formulario propio con el passwordEncoder
                .and().formLogin(/*form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")*/).defaultSuccessUrl("/",true)
                // estos dos se usan juntos si quiero utilizar cookies
                .and().rememberMe().key("uniqueAndSecret")
                .and().logout().deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
