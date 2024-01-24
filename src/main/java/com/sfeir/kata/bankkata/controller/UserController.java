package com.sfeir.kata.bankkata.controller;

import com.sfeir.kata.bankkata.dto.UserDto;
import com.sfeir.kata.bankkata.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PutMapping
    public UserDto createUser(String role, String password) {

        return userService.createUser(role, password);
    }

    // Delete a user
    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }


    // Update user rights
    @PatchMapping(value = "/{userId}/roles")
    public UserDto updateUserRole(@PathVariable Long userId, @RequestParam String newRole) {

        return userService.updateUserRole(userId, newRole);
    }


    // Update user with client information
    @PatchMapping(value = "/{userId}/client/{clientId}")
    public UserDto updateUserClientId(@PathVariable Long userId, @PathVariable Long clientId) {

        return userService.updateUserClientId(userId, clientId);
    }


    // Update user with client information
    @PatchMapping(value = "/{userId}/password")
    public UserDto updateUserPassword(@PathVariable Long userId, @RequestParam String newPassword) {

        return userService.updateUserPassword(userId, newPassword);
    }

}
