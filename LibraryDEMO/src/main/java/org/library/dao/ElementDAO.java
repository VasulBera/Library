package org.library.dao;

import java.util.List;

public interface ElementDAO<E> {
    
    public void add(E element);
    public void update(E element);
    public E findByID(Long elementId);
    public List<E> getAll();
    public void delete(E element);
}

