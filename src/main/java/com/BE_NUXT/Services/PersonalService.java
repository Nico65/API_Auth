package com.BE_NUXT.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BE_NUXT.Entity.PersonalEntity;
import com.BE_NUXT.Repository.PersonalRepository;

@Service
public class PersonalService {

	
	private final PersonalRepository personalRepo;
	
	public PersonalService(PersonalRepository personalRepo) {
		this.personalRepo = personalRepo;
	}
	
	public List<PersonalEntity> getAllPersonal(){
		return personalRepo.findAll();
	}
	
	public PersonalEntity getPersonalById(int id) {
		
		return personalRepo.findById(id).orElse(null);
	}
	
	public PersonalEntity addPersonal(PersonalEntity personal) {
		if(personalRepo.existsByEmail(personal.getEmail())) {
			throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
			
		}
		return personalRepo.save(personal);
	}
	
}
