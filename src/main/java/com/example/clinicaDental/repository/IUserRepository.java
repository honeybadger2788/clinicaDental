package com.example.clinicaDental.repository;

import com.example.clinicaDental.entity.Patient;
import com.example.clinicaDental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.username = ?1 order by u.username")
    User findByUsername(String username);
}
