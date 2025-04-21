package com.yogi.service;

import com.yogi.model.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        return new User(firstName, lastName, email, UUID.randomUUID().toString());
    }

}
