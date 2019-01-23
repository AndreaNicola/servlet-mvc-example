package services;

import models.Genere;

import java.util.Collection;

public interface IGenereService {

    Collection<Genere> list();

    Genere get(Long id);

    void insert(String nome);

    void update(Long id, String nome);

    void delete(Long id);

}
