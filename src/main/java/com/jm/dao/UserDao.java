package com.jm.dao;

import com.jm.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void removeUser(long id);
   void updateUser(User user);
   User getUserById(long id);
   List<User> listUsers();
}
