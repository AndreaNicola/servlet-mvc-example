package dao;

import models.Genere;

import java.util.Collection;

public interface IGenereDao extends IDao<Genere> {

    Collection<Genere> listByLibro(Long id);
}
