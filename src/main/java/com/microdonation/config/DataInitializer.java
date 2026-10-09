package com.microdonation.config;

import com.microdonation.model.User;
import com.microdonation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserService userService;
    
    @Override
    public void run(String... args) throws Exception {
        if (userService.getAllUsers().isEmpty()) {
            User user1 = new User();
            user1.setName("John Doe");
            user1.setEmail("john@example.com");
            user1.setContactNo("1234567890");
            userService.saveUser(user1);
            
            User user2 = new User();
            user2.setName("Jane Smith");
            user2.setEmail("jane@example.com");
            user2.setContactNo("0987654321");
            userService.saveUser(user2);
            
            User user3 = new User();
            user3.setName("Admin User");
            user3.setEmail("admin@example.com");
            user3.setContactNo("5555555555");
            userService.saveUser(user3);
        }
    }
}