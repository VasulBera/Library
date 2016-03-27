package org.library.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.library.entity.Book;
import org.library.entity.Instance;

public class InstanceDAO extends ElementDAOImp<Instance, Integer> implements Findable<Instance>{

    public InstanceDAO() {
	super(Instance.class);
    }

    @Override
    public List<Instance> findByName(String name) {
	EntityManager entityManager = ElementDAOImp.getEntityManager();
	Book book = (Book) entityManager.createQuery("SELECT b FROM Book b where b.name = ?1").setParameter(1, name).getSingleResult();
	List<Instance> instances = entityManager.createQuery("SELECT i FROM Instance i where i.book = ?1", Instance.class)
                .setParameter(1, book).getResultList();
	return instances;
    }
    
}
