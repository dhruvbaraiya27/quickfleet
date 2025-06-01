package com.quickfleet.repository;

import com.quickfleet.model.Role;
import com.quickfleet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
