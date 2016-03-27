package org.library.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.library.dao.DAOFactory;
import org.library.dao.ElementDAOImp;
import org.library.entity.Book;
import org.library.entity.Instance;

public class InstanceServices {

    public void saveInstance(Instance instance){
	if (instance == null){
	    return;
	}
	Book book = instance.getBook();
	EntityManager entityManager = ElementDAOImp.getEntityManager();
	entityManager.getTransaction().begin();
	List<Book> listOfBooks = entityManager.createQuery("SELECT b FROM Book b where b.name = ?1 AND b.amountOfPage = ?2 AND b.year = ?3", Book.class).
		setParameter(1, book.getName()).setParameter(2, book.getAmountOfPage()).setParameter(3, book.getYear()).getResultList();
	if(listOfBooks.size() > 0){
	    book = listOfBooks.get(0);
	}
	entityManager.getTransaction().commit();
	instance.setBook(book);
	DAOFactory.getInstance().getInstanceDAO().save(instance);
    }
    
    public void deleteInstance(Instance instance){
	DAOFactory.getInstance().getInstanceDAO().delete(instance);
    }
    
    public Instance findByID(int id){
	Instance instance = DAOFactory.getInstance().getInstanceDAO().findByID(id);
	return instance;
    }
    
    public List<Instance> findByName(String name){
	List<Instance> instances = DAOFactory.getInstance().getInstanceDAO().findByName(name);
	return instances;
    }
}
