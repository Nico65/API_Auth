package com.BE_NUXT.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BE_NUXT.Configuration.JwtUtils;
import com.BE_NUXT.Entity.Authentication;
import com.BE_NUXT.Services.AuthService;

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
    public ResponseEntity<String> login(@RequestBody Authentication loginRequest) {
        // Authenticate the user
    	System.out.println("USERNAME: "+loginRequest.getUsername());
    	System.out.println("PASSWORD: "+loginRequest.getPassword());
    	
        Optional<Authentication> userOptional = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (userOptional.isPresent()) {
            // If authentication is successful, generate the token
            String token = jwtUtils.generateToken(userOptional.get().getUsername());
            System.out.println("TOKEN: "+token);
            return ResponseEntity.ok(token);
        } else {
            // If authentication fails, return unauthorized response
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    
    // Register new user and return status message
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Authentication registerRequest) {
        // Call the UserService to handle registration and get the status message
        String message = authService.registerUser(registerRequest.getUsername(), registerRequest.getPassword());
        
        if (message.equals("User registered successfully!")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
    
    @GetMapping("/users")
    public List<Authentication> getUsers(){
    	return authService.getAllUsers();
    }

}
