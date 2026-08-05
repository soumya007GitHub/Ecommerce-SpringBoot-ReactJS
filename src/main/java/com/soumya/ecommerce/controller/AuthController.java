package com.soumya.ecommerce.controller;

import com.soumya.ecommerce.model.User;
import com.soumya.ecommerce.repository.UserRepository;
import com.soumya.ecommerce.response.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody SignupRequest signupRequest){
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setFullName(signupRequest.getFullName());
        User savedUser = userRepo.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
