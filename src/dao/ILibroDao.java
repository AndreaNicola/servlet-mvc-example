package dao;

import models.Libro;

import java.util.Collection;

public interface ILibroDao extends IDao<Libro> {

    void create(Libro libro, Collection<Long> generi);
    void update(Libro libro, Collection<Long> generi);

}
