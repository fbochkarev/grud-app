package com.jm.dao;

import com.jm.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("grud-app");
        return emf.createEntityManager();
    }

    @Override
    public void add(User user) {
        EntityManager em = getEntityManager();
        em.merge(user);
    }

    @Override
    public void removeUser(long id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public void updateUser(User user) {
        EntityManager em = getEntityManager();
        em.merge(user);
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