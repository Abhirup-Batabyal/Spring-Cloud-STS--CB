package com.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.user.service.model.AppUser;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private com.user.service.repository.UserRepository userRepository;

    @GetMapping
    public List<com.user.service.model.AppUser> getAllUsers() {  // Use 'AppUser' instead of 'User'
        return UserController.findById();
            }
        
            private static List<com.user.service.model.AppUser> findById() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'findById'");
            }
        
            @GetMapping("/{id}")
    public Optional<com.user.service.model.AppUser> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public AppUser createUser(@RequestBody com.user.service.model.AppUser user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public AppUser updateUser(@PathVariable Long id, @RequestBody com.user.service.model.AppUser updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully!";
    }
}
