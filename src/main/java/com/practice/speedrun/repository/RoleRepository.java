package com.practice.speedrun.repository;

import com.practice.speedrun.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
