package org.library.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ElementDAOImp<E, PK extends Serializable> implements ElementDAO<E, PK>{
    
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
    public void save(E element) {
	EntityManager entityManager = ElementDAOImp.getEntityManager();
	entityManager.getTransaction().begin();
	entityManager.persist(element);
	entityManager.getTransaction().commit();
    }

    @Override
    public E findByID(PK elementId) {
	EntityManager entityManager = ElementDAOImp.getEntityManager();
	entityManager.getTransaction().begin();
	E element = entityManager.find(elementClass, elementId);
	entityManager.getTransaction().commit();
	return element;
    }

    @Override
    public void delete(E element) {
	EntityManager entityManager = ElementDAOImp.getEntityManager();
	entityManager.getTransaction().begin();
	if(element != null){
	    entityManager.remove(element);
	}
	entityManager.getTransaction().commit();
    }
}
