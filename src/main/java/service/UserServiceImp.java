package service;

import dao.UserDao;
import dao.UserDaoImp;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    UserDao userDao = new UserDaoImp();

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
