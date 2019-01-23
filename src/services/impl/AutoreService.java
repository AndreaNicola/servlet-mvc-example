package services.impl;

import dao.FactoryDao;
import dao.IAutoreDao;
import models.Autore;
import services.IAutoreService;

import java.util.Collection;

public class AutoreService implements IAutoreService {

    private final static IAutoreDao I_AUTORE_DAO = FactoryDao.getiAutoreDao();

    @Override
    public Collection<Autore> list() {
        return I_AUTORE_DAO.list();
    }

    @Override
    public Autore get(Long id) {
        return I_AUTORE_DAO.get(id);
    }

    @Override
    public void insert(String nome, String cognome) {
        Autore autore = new Autore();
        autore.setNome(nome);
        autore.setCognome(cognome);
        I_AUTORE_DAO.create(autore);
    }

    @Override
    public void update(Long id, String nome, String cognome) {
        Autore autore = new Autore();
        autore.setId(id);
        autore.setCognome(cognome);
        autore.setNome(nome);
        I_AUTORE_DAO.update(autore);
    }

    @Override
    public void delete(Long id) {
        I_AUTORE_DAO.delete(id);
    }

}
