package com.example.examserver.services;

import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User User, Set<UserRole> userRoles) throws Exception;

    public User getUser(Long id);

    public void deleteUser(Long userId);
}
