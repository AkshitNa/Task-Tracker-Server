package com.nautiDevelopers.Todo.Repository;

import com.nautiDevelopers.Todo.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

}
