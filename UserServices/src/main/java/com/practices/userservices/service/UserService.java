package com.practices.userservices.service;
/*
 * author: Sadik Hassan
 * created: 6:56 pm, 02/10/2022
 */

import com.practices.userservices.domain.Role;
import com.practices.userservices.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
