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

import com.BE_NUXT.Entity.PersonalEntity;
import com.BE_NUXT.Services.PersonalService;

@RestController
@RequestMapping("/api")
public class PersonalController {
	
	@Autowired
	private PersonalService personService;
	
	@GetMapping("/users")
	public List<PersonalEntity> requestMethodName() {
	    return personService.getAllPersonal();
	}
	
	@PostMapping("/add_personal")
	public ResponseEntity<?> addPersonal(@Validated @RequestBody PersonalEntity personal) {
		
		try {
            PersonalEntity savedPersonal = personService.addPersonal(personal);
            return ResponseEntity.ok(savedPersonal);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
	}
}
