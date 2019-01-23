package services;

import models.Libro;

import java.util.Collection;

public interface ILibroService {

    Collection<Libro> list();

    Libro get(Long id);

    void insert(String titolo, String descrizione, Long autoreId, Collection<Long> generi);

    void update(Long id, String titolo, String descrizione, Long autoreId, Collection<Long> generi);

    void delete(Long id);

}
