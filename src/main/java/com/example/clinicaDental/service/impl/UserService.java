package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.entity.Rol;
import com.example.clinicaDental.entity.User;
import com.example.clinicaDental.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> appUser = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantList = new HashSet<>();
        for (Rol rol:
                appUser.get().getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getDescription());
            grantList.add(grantedAuthority);
        }

        // cambié el primer parametro porque le estoy pasando un usuario aunque no lo encuentre en la linea 27
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(appUser.get().getUsername(),"{noop}"+appUser.get().getPassword(),grantList);
        return userDetails;
    }
}
