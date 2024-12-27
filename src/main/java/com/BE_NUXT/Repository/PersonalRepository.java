package com.BE_NUXT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BE_NUXT.Entity.PersonalEntity;

@Repository
public interface PersonalRepository extends JpaRepository<PersonalEntity, Integer> {

	boolean existsByEmail(String email);
}
