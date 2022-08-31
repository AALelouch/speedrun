package com.practice.speedrun.repository;

import com.practice.speedrun.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
