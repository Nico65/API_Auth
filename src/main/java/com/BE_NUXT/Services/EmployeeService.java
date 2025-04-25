package com.BE_NUXT.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BE_NUXT.Entity.EmployeeEntity;
import com.BE_NUXT.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	
	private final EmployeeRepository personalRepo;
	
	public EmployeeService(EmployeeRepository personalRepo) {
		this.personalRepo = personalRepo;
	}
	
	public List<EmployeeEntity> getAllPersonal(){
		return personalRepo.findAll();
	}
	
	public EmployeeEntity getPersonalById(int id) {
		
		return personalRepo.findById(id).orElse(null);
	}
	
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		if(personalRepo.existsByEmail(employee.getEmail())) {
			throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
			
		}
		return personalRepo.save(employee);
	}
	
}
