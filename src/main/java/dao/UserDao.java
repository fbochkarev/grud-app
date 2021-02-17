package dao;

import model.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDao {
   EntityManager getEntityManager();
   User getUserById(long id);
   List listUsers();
}
