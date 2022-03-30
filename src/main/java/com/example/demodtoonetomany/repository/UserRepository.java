package com.example.demodtoonetomany.repository;

import com.example.demodtoonetomany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
