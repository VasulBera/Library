package org.library.DAOImp;

import java.util.List;
import javax.persistence.EntityManager;
import org.library.dao.ElementDAOImp;
import org.library.entity.Book;
import org.library.entity.Instance;

public class BookDAOImp extends ElementDAOImp<Book> implements org.library.dao.BookDAO{

    public BookDAOImp(Class<Book> elementClass) {
	super(elementClass);
	// TODO Auto-generated constructor stub
    }
    @Override
    public List<Instance> findByName(String name) {
	EntityManager entityManager = ElementDAOImp.getEntityManager();
	Book book = (Book) entityManager.createQuery("SELECT b FROM Book b where b.name = ?").setParameter(1, name).getSingleResult();
	List<Instance> instances = entityManager.createQuery("SELECT i FROM Instance i where i.book = ?")
                .setParameter(1, book).getResultList();
	return instances;
    }

}
