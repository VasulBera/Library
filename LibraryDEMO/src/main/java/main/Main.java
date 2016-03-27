package main;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.library.DAOImp.BookDAOImp;
import org.library.dao.ElementDAOImp;
import org.library.entity.Book;
import org.library.entity.Instance;

public class Main {
   
    public static void main(String[] args) {
	/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAService");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	Book book = new Book();
	book.setAmountOfPage(1000);
	book.setYear(2007);
	book.setName("Êמבחאנ");
	Instance ins = new Instance();
	ins.setAvailable(true);
	ins.setBook(book);
	em.persist(ins);
	em.getTransaction().commit();
	
	em.close();
	emf.close();*/
	BookDAOImp b = new BookDAOImp(Book.class);
	List<Instance> res = b.findByName("Êמבחאנ");
	System.out.println(res);
	
	
	
	
	
	/*EntityManager entityManager = ElementDAOImp.getEntityManager();
	TypedQuery<Book> tq = entityManager.createQuery("from Book WHERE column=name", Book.class);
	    Book book = tq.setParameter(1, name).getSingleResult();
	    TypedQuery<Instance> tq2 = entityManager.createQuery("from Instance WHERE column=book_id", Instance.class);
	    List<Instance> ins = tq2.setParameter(1, book.getId()).getResultList();
	return ins;*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    }

}
