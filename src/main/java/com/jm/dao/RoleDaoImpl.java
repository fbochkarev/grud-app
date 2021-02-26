package com.jm.dao;

import com.jm.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class RoleDaoImpl {
    private EntityManagerFactory emf;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("grud-app");
        return emf.createEntityManager();
    }

    public List<Role> listUsers() {
        return getEntityManager().createQuery("from Role").getResultList();
    }

}
