package com.quickfleet.service;

import com.quickfleet.dto.RegisterRequest;
import com.quickfleet.model.Role;
import com.quickfleet.model.User;
import com.quickfleet.repository.RoleRepository;
import com.quickfleet.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // Ensure default roles exist
    @PostConstruct
    public void initRoles() {
        if (roleRepository.findByName("CUSTOMER").isEmpty()) {
            roleRepository.save(new Role(null, "CUSTOMER"));
        }
        if (roleRepository.findByName("COURIER").isEmpty()) {
            roleRepository.save(new Role(null, "COURIER"));
        }
        if (roleRepository.findByName("ADMIN").isEmpty()) {
            roleRepository.save(new Role(null, "ADMIN"));
        }
    }

    public User register(RegisterRequest request) {
        Role role = roleRepository.findByName(request.getRole().toUpperCase())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 🔐 hash
        user.setRole(role);

        return userRepository.save(user);
    }
}