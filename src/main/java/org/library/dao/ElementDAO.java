package org.library.dao;

import java.io.Serializable;

public interface ElementDAO<E, PK extends Serializable> {
    
    public void save(E element);
    public E findByID(PK elementId);
    public void delete(E element);
}

