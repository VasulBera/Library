package org.library.dao;

import java.util.List;

import org.library.entity.Book;
import org.library.entity.Instance;

public interface BookDAO{
    
    public List<Instance> findByName(String name);

}
