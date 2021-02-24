package com.jm.dao;

import com.jm.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDao {
   EntityManager getEntityManager();
   void add(User user);
   void removeUser(long id);
   void updateUser(User user);
   User getUserById(long id);
   List<User> listUsers();
   User getUserByName(String name);
   List getUserFromUserList(String username);
}
