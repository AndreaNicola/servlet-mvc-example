package dao;

import java.util.Collection;

interface IDao<T> {

    Collection<T> list();

    T get(Long id);

    void create(T t);

    void update(T t);

    void delete(Long id);

}
