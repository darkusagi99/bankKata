package com.sfeir.kata.bankkata.dto;

import com.sfeir.kata.bankkata.model.User;

public record UserDto(Long userId, Long clientId) {

    public UserDto(User user) {
        this(user.userId, user.clientId);
    }

}
