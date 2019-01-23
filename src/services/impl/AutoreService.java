package services.impl;

import dao.FactoryDao;
import models.Autore;
import services.IAutoreService;

import java.util.Collection;

public class AutoreService implements IAutoreService {

    @Override
    public Collection<Autore> list() {
        return FactoryDao.getiAutoreDao().list();
    }

}
