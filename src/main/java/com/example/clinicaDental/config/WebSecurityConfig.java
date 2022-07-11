package com.example.clinicaDental.config;

import com.example.clinicaDental.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().authorizeRequests()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/index.html").hasRole("USER")
                .antMatchers("/formDentist.html").hasRole("ADMIN")
                .antMatchers("/formPatient.html").hasRole("ADMIN")
                .antMatchers("/formAppointment.html").hasRole("USER")
                .antMatchers("/listDentists.html").hasRole("ADMIN")
                .antMatchers("/listPatients.html").hasRole("ADMIN")
                .antMatchers("/listAppointments.html").hasRole("USER")
                .and().formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true"))
                // estos dos se usan juntos si quiero utilizar cookies
                .rememberMe().key("uniqueAndSecret")
                .and().logout().deleteCookies("JSESSIONID");
    }

}
