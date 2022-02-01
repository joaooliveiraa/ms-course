package com.oliveira.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
