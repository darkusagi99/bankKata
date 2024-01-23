package com.sfeir.kata.bankkata.controller;

import com.sfeir.kata.bankkata.dto.UserDto;
import com.sfeir.kata.bankkata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PutMapping
    public UserDto createUser(String role, String password) {

        return userService.createUser(role, password);
    }

    // Delete a user
    @DeleteMapping(value = "/{userId}")
    public UserDto deleteUser(@PathVariable Long userId) {

        return userService.deleteUser(userId);
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
