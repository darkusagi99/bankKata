package com.sfeir.kata.bankkata.service;

import com.sfeir.kata.bankkata.dto.UserDto;
import com.sfeir.kata.bankkata.model.Client;
import com.sfeir.kata.bankkata.model.User;
import com.sfeir.kata.bankkata.repository.ClientRepository;
import com.sfeir.kata.bankkata.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Class for user information */
@Service
public class UserService {

    private final UserRepository userRepository;

    private final ClientRepository clientRepository;

    public UserService(UserRepository userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    public UserDto createUser(String username, String role, String password) {


        // Calculate password hash
        String passwordHash = this.generatePasswordHash(password);

        User.UserBuilder builder = new User.UserBuilder(username, passwordHash, role);
        User newUser = new User(builder);

        userRepository.save(newUser);

        return new UserDto(newUser);
    }

    // Delete a user

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

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
            String passwordHash = this.generatePasswordHash(newPassword);

            User tmpUser = currentUser.get();
            tmpUser.setPasswordHash(passwordHash);
            userRepository.save(tmpUser);

            return new UserDto(tmpUser);
        }

        return null;
    }


    private String generatePasswordHash(String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(newPassword);
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);

        return userList;
    }



}
