package service;

import model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void removeUser(long id);
    void updateUser(User user);
    List<User> listUsers();
}
