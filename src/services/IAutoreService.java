package services;

import models.Autore;

import java.util.Collection;

public interface IAutoreService {

    Collection<Autore> list();

    Autore get(Long id);

    void insert(String nome, String cognome);

    void update(Long id, String nome, String cognome);

    void delete(Long id);

}
