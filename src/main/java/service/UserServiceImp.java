package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("grud-app");
        return emf.createEntityManager();
    }

    @Override
    public void add(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void removeUser(long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
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
