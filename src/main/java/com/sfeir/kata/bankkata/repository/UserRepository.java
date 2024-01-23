package com.sfeir.kata.bankkata.repository;

import com.sfeir.kata.bankkata.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
