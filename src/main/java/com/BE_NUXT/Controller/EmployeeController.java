package com.BE_NUXT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BE_NUXT.Entity.EmployeeEntity;
import com.BE_NUXT.Services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/users")
	public List<EmployeeEntity> requestMethodName() {
	    return employeeService.getAllPersonal();
	}
	
	@PostMapping("/add_employee")
	public ResponseEntity<String> addPersonal(@Validated @RequestBody EmployeeEntity employee) {
		
		try {
            EmployeeEntity savedPersonal = employeeService.addEmployee(employee);
            return ResponseEntity.ok("Employee added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
	}
}
