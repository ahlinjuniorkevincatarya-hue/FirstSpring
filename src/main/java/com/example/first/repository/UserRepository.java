package com.example.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.first.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
