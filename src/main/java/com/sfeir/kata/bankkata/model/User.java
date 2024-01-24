package com.sfeir.kata.bankkata.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_USER")
public class User {

    @Id
    @GeneratedValue
    public Long userId;

    @Column(nullable = false)
    public String username;

    @Column(nullable = false)
    public String passwordHash;
    @Column(nullable = false)
    public String role;

    public User() {

    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Column
    public Long clientId;

    public User(UserBuilder builder) {
        this.username = builder.username;
        this.passwordHash = builder.passwordHash;
        this.role = builder.role;
        this.clientId = builder.clientId;

    }

    public static class UserBuilder {

        private final String passwordHash;

        private final String role;

        private Long clientId;

        private final String username;

        public UserBuilder(String username, String passwordHash, String role) {
            this.username = username;
            this.passwordHash = passwordHash;
            this.role = role;
        }

        public void setClientId(Long clientId) {
            this.clientId = clientId;
        }
    }

}
