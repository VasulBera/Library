package org.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ElementDAOImp<E> implements ElementDAO<E>{
    
    public static final String NAME_XML_CONFIG = "JPAService";
    public Class<E> elementClass;
    public static EntityManager entityManager;
    
    public ElementDAOImp(Class<E> elementClass) {
	super();
	this.elementClass = elementClass;
    }
    
    public static EntityManager getEntityManager(){
	if (entityManager == null){
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(NAME_XML_CONFIG);
	    entityManager = entityManagerFactory.createEntityManager();
	    return entityManager;
	}else{
	    return entityManager;
	}
    }
    @Override
    public void add(E element) {
	getEntityManager().getTransaction();
	entityManager.persist(element);
	entityManager.getTransaction().commit();
    }

    @Override
    public void update(E element) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public E findByID(Long elementId) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<E> getAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(E element) {
	// TODO Auto-generated method stub
	
    }

}
