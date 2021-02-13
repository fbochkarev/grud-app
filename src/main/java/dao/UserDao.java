package dao;

import model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void removeUser(long id);
   void updateUser(User user);
   List listUsers();
}