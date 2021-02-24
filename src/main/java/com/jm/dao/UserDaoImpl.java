package com.jm.dao;

import com.jm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

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

    @Override
    public User getUserByName(String username) {
        User user = getEntityManager().createQuery(
                "SELECT u from User u WHERE u.username = :username", User.class).
                setParameter("username", username).getSingleResult();
        System.out.println(getClass().getName()+ " - " + user.toString());
        return user;
    }

    @Override
    public List getUserFromUserList(String username) {
        return getEntityManager().createQuery("SELECT u from User u WHERE u.username = :username").getResultList();
    }
}