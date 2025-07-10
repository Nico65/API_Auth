package com.BE_NUXT.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BE_NUXT.Configuration.JwtUtils;
import com.BE_NUXT.Entity.Users;
import com.BE_NUXT.Services.AuthService;
import com.BE_NUXT.Services.LoginResponseDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final JwtUtils jwtUtils;
	private final AuthService authService;

    public AuthController(JwtUtils jwtUtils, AuthService userService) {
        this.jwtUtils = jwtUtils;
        this.authService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody Users loginRequest) {
    	System.out.println("Email: "+ loginRequest.getEmail());
    	
    	Optional<Users> userOptional = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (userOptional.isPresent()) {
            String token = jwtUtils.generateToken(userOptional.get().getEmail());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } else {
            // Envoie un message d'erreur clair
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(new LoginResponseDTO(null, "Invalid username or password"));
        }
    }
    
    // Register new user and return status message
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users registerRequest) {
        // Call the UserService to handle registration and get the status message
        String message = authService.registerUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmail(), registerRequest.getRole());
        
        if (message.equals("User registered successfully!")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
    
//    @GetMapping("/users")
//    public List<Users> getUsers(){
//    	return authService.getAllUsers();
//    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        return ResponseEntity.ok(authService.getAllUsers());
    }
}
