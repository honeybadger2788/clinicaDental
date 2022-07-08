package com.example.clinicaDental.repository;

import com.example.clinicaDental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
