package dao;

import dao.impl.AutoreDao;
import dao.impl.GenereDao;
import dao.impl.LibroDao;

public class FactoryDao {

    private final static IAutoreDao I_AUTORE_DAO = new AutoreDao();
    private final static ILibroDao I_LIBRO_DAO = new LibroDao();
    private final static IGenereDao I_GENERE_DAO = new GenereDao();

    public static IAutoreDao getiAutoreDao() {
        return I_AUTORE_DAO;
    }

    public static IGenereDao getiGenereDao() {
        return I_GENERE_DAO;
    }

    public static ILibroDao getiLibroDao() {
        return I_LIBRO_DAO;
    }

}
