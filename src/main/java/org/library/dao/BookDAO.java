package org.library.dao;

import java.util.List;

import org.library.entity.Book;
import org.library.entity.Instance;

public class BookDAO extends ElementDAOImp<Book, Integer>{

    public BookDAO() {
	super(Book.class);
    }
}
