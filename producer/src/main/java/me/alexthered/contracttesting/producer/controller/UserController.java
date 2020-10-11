package me.alexthered.contracttesting.producer.controller;

import me.alexthered.contracttesting.producer.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @GetMapping("/{userId}")
  public User getMe(@PathVariable Integer userId) {
    return User.builder()
        .id(userId)
        .firstName("John")
        .lastName("Doe")
        .email("john.doe@gmail.com")
        .build();
  }
}
