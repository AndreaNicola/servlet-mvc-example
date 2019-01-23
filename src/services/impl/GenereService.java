package services.impl;

import dao.FactoryDao;
import dao.IGenereDao;
import models.Genere;
import services.IGenereService;

import java.util.Collection;

public class GenereService implements IGenereService {

    private static final IGenereDao I_GENERE_DAO = FactoryDao.getiGenereDao();

    @Override
    public Collection<Genere> list() {
        return I_GENERE_DAO.list();
    }

    @Override
    public Collection<Genere> listByLibro(Long libroId) {
        return I_GENERE_DAO.listByLibro(libroId);
    }

    @Override
    public Genere get(Long id) {
        return I_GENERE_DAO.get(id);
    }

    @Override
    public void insert(String nome) {
        Genere genere = new Genere();
        genere.setNome(nome);
        I_GENERE_DAO.create(genere);
    }

    @Override
    public void update(Long id, String nome) {
        Genere genere = new Genere();
        genere.setId(id);
        genere.setNome(nome);
        I_GENERE_DAO.update(genere);
    }

    @Override
    public void delete(Long id) {
        I_GENERE_DAO.delete(id);
    }


}
