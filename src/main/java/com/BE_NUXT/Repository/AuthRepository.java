package com.BE_NUXT.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE_NUXT.Entity.Authentication;

@Repository
public interface AuthRepository extends JpaRepository<Authentication, Integer> {

	Optional<Authentication> findByUsername(String username);
}
