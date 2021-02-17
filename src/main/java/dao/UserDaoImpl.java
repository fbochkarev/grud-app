package dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("grud-app");
        return emf.createEntityManager();
    }

    @Override
    public User getUserById(long id) {
        EntityManager em = getEntityManager();
        return em.getReference(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return getEntityManager().createQuery("from User").getResultList();
    }
}