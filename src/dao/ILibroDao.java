package dao;

import models.Libro;

import java.util.Collection;

public interface ILibroDao extends IDao<Libro> {

    void create(Libro libro, Collection<Long> generi);

    void update(Libro libro, Collection<Long> generi);

    Collection<Libro> listByAutore(Long autoreId);

    Collection<Libro> listByGenere(Long genereId);
}
