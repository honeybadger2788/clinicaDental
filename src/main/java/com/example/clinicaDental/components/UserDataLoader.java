package com.example.clinicaDental.components;

import com.example.clinicaDental.Role;
import com.example.clinicaDental.entity.User;
import com.example.clinicaDental.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader implements ApplicationRunner {
    @Autowired
    IUserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("admin");
        String password2 = passwordEncoder.encode("user");

        userRepository.save(new User("admin",password, Role.ROLE_ADMIN));
        userRepository.save(new User("user",password2, Role.ROLE_USER));
    }
}
