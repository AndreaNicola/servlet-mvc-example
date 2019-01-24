package services;

import models.Libro;

import java.util.Collection;

public interface ILibroService {

    Collection<Libro> list();

    Collection<Libro> listByAutore(Long autoreId);
    Collection<Libro> listByGenere(Long genereId);

    Libro get(Long id);

    void insert(String titolo, String descrizione, Long autoreId, Collection<Long> generi);

    void update(Long id, String titolo, String descrizione, Long autoreId, Collection<Long> generi);

    void delete(Long id);

}
