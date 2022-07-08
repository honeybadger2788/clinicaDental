package com.example.clinicaDental.service.impl;

import com.example.clinicaDental.entity.Rol;
import com.example.clinicaDental.entity.User;
import com.example.clinicaDental.repository.IUserRepository;
import com.example.clinicaDental.service.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsService implements IUserDetailsService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User appUser = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
        for (Rol rol:
             appUser.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getDescription());
            grantList.add(grantedAuthority);
        }

        UserDetails user = null;
        user = (UserDetails) new User(username,"{noop}"+ appUser.getPassword(), grantList);
        return user;
    }
}
