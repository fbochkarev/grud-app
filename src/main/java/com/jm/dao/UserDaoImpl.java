package com.jm.dao;

import com.jm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em = getEntityManager();

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("grud-app");
        return emf.createEntityManager();
    }

    @Override
    public void add(User user) {
//        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        System.out.println(getClass() + " - add - " + user);
        if (user.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        }
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void removeUser(long id) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
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

    @Override
    public User getUserByName(String username) {
        User user = getEntityManager().createQuery(
                "SELECT u from User u WHERE u.username = :username", User.class).
                setParameter("username", username).getSingleResult();
        System.out.println(getClass() + " - getUserByName - " + user.toString());
        return user;
    }

    @Override
    public List getUserFromUserList(String username) {
        return getEntityManager().createQuery("SELECT u from User u WHERE u.username = :username").getResultList();
    }
}