package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.UserDto;
import com.sfeir.kata.bankkata.model.Client;
import com.sfeir.kata.bankkata.model.User;
import com.sfeir.kata.bankkata.repository.ClientRepository;
import com.sfeir.kata.bankkata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/** Class for user information */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    public UserDto createUser(String role, String password) {

        User.UserBuilder builder = new User.UserBuilder(password, role);
        User newUser = new User(builder);

        userRepository.save(newUser);

        return new UserDto(newUser);
    }

    // Delete a user

    public UserDto deleteUser(Long userId) {

        userRepository.deleteById(userId);

        return null;
    }


    // Update user rights

    public UserDto updateUserRole(Long userId, String role) {

        Optional<User> currentUser = userRepository.findById(userId);

        if (currentUser.isPresent()) {
            User tmpUser = currentUser.get();
            tmpUser.setRole(role);
            userRepository.save(tmpUser);

            return new UserDto(tmpUser);
        }

        return null;
    }


    // Update user with client information

    public UserDto updateUserClientId(Long userId, Long clientId) {

        Optional<User> currentUser = userRepository.findById(userId);
        Optional<Client> currentClient = clientRepository.findById(clientId);

        if (currentUser.isPresent() && currentClient.isPresent()) {
            User tmpUser = currentUser.get();
            tmpUser.setClientId(clientId);
            userRepository.save(tmpUser);

            return new UserDto(tmpUser);
        }

        return null;
    }


    // Update user with client information
    public UserDto updateUserPassword(Long userId, String newPassword) {

        Optional<User> currentUser = userRepository.findById(userId);

        // Update account
        if (currentUser.isPresent()) {

            // Calculate password hash
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String passwordHash = passwordEncoder.encode(newPassword);

            User tmpUser = currentUser.get();
            tmpUser.setPasswordHash(passwordHash);
            userRepository.save(tmpUser);

            return new UserDto(tmpUser);
        }

        return null;
    }



}
