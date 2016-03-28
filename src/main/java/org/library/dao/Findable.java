package org.library.dao;

import java.util.List;

public interface Findable<E> {
    public List<E> findByName(String name);
}
