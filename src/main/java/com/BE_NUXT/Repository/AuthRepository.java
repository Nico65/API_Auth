package com.BE_NUXT.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE_NUXT.Entity.Users;

@Repository
public interface AuthRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUsername(String username);
	
	Optional<Users> findByEmail(String email);
	
}
