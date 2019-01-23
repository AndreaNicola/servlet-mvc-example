package dao.impl;

import dao.ILibroDao;
import models.Libro;

import java.util.Collection;

public class LibroDao extends  AbstractDao implements ILibroDao {

    @Override
    public Collection<Libro> list() {
        return null;
    }

    @Override
    public Libro get(Long id) {
        return null;
    }

    @Override
    public void create(Libro book) {

    }

    @Override
    public void update(Libro book) {

    }

    @Override
    public void delete(Long id) {

    }
}
