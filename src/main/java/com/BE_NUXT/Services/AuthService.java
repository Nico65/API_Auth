package com.BE_NUXT.Services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.BE_NUXT.Entity.Users;
import com.BE_NUXT.Repository.AuthRepository;

@Service
public class AuthService {
	
	private final AuthRepository authRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository, BCryptPasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Users> authenticate(String email, String password) {
        // Find user by username
        Optional<Users> userOptional = authRepository.findByEmail(email);
        
        if (userOptional.isPresent()) {
        	Users user = userOptional.get();
            // Check if the password matches the hashed password in the database
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user); // Users successful
            }
        }
        return Optional.empty(); // Users failed
    }
    
    public List<Users> getAllUsers(){
    	return authRepository.findAll();
    }
    
    public String registerUser(String username, String password, String email, String role) {
        // Check if username already exists in the database
        if (authRepository.findByUsername(username).isPresent()) {
            return "Username is already taken.";  // Return message if user exists
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(password);

//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        // Create a new user object
        Users newUser = new Users();
        newUser.setUsername(username);
        newUser.setPassword(hashedPassword);
        newUser.setEmail(email);
        newUser.setRole(role);

        // Save the user to the database
        authRepository.save(newUser);

        // Return success message
        return "User registered successfully!";
    }

}
