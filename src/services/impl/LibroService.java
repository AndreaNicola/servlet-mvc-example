package services.impl;

import dao.FactoryDao;
import dao.ILibroDao;
import models.Libro;
import services.ILibroService;

import java.util.Collection;

public class LibroService implements ILibroService {

    private static final ILibroDao I_LIBRO_DAO = FactoryDao.getiLibroDao();

    @Override
    public Collection<Libro> list() {
        return I_LIBRO_DAO.list();
    }

    @Override
    public Libro get(Long id) {
        return I_LIBRO_DAO.get(id);
    }

    @Override
    public void insert(String titolo, String descrizione, Long autoreId, Collection<Long> generi) {
        Libro libro = new Libro();
        libro.setTitolo(titolo);
        libro.setDescrizione(descrizione);
        libro.setAutoreId(autoreId);
        I_LIBRO_DAO.create(libro, generi);
    }

    @Override
    public void update(Long id, String titolo, String descrizione, Long autoreId, Collection<Long> generi) {
        Libro libro = new Libro();
        libro.setTitolo(titolo);
        libro.setId(id);
        libro.setDescrizione(descrizione);
        libro.setAutoreId(autoreId);
        I_LIBRO_DAO.update(libro,generi);
    }

    @Override
    public void delete(Long id) {
        I_LIBRO_DAO.delete(id);
    }
}
