package com.example.clinicaDental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").hasRole("USER")
                .antMatchers("/formDentist.html").hasRole("ADMIN")
                .antMatchers("/formPatient.html").hasRole("ADMIN")
                .antMatchers("/formAppointment.html").hasRole("USER")
                .antMatchers("/listDentists.html").hasRole("ADMIN")
                .antMatchers("/listPatients.html").hasRole("ADMIN")
                .antMatchers("/listAppointments.html").hasRole("USER")
                .and().formLogin()
                // estos dos se usan juntos si quiero utilizar cookies
                .and().rememberMe().key("uniqueAndSecret")
                .and().logout().deleteCookies("JSESSIONID");
    }
}
