package com.BE_NUXT.Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.BE_NUXT.Entity.Authentication;
import com.BE_NUXT.Repository.AuthRepository;

@Service
public class AuthService {
	
	private final AuthRepository authRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository, BCryptPasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Authentication> authenticate(String username, String password) {
        // Find user by username
        Optional<Authentication> userOptional = authRepository.findByUsername(username);
        
        if (userOptional.isPresent()) {
        	Authentication user = userOptional.get();
            // Check if the password matches the hashed password in the database
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user); // Authentication successful
            }
        }
        return Optional.empty(); // Authentication failed
    }
    
    public List<Authentication> getAllUsers(){
    	return authRepository.findAll();
    }
    
    public String registerUser(String username, String password) {
        // Check if username already exists in the database
        if (authRepository.findByUsername(username).isPresent()) {
            return "Username is already taken.";  // Return message if user exists
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(password);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        // Create a new user object
        Authentication newUser = new Authentication();
        newUser.setUsername(username);
        newUser.setPassword(hashedPassword);

        // Save the user to the database
        authRepository.save(newUser);

        // Return success message
        return "User registered successfully!";
    }

}
