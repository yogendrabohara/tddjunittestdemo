package com.yogi.repository;

import com.yogi.model.User;

public interface UserRepository {
    boolean save(User user);
}
