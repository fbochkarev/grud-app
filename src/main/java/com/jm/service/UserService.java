package com.jm.service;

import com.jm.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void removeUser(long id);
    void updateUser(User user);
    User getUserById(long id);
    List<User> listUsers();
    List getUserFromUserList(String username);
}
