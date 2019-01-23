package services;

import services.impl.AutoreService;
import services.impl.GenereService;
import services.impl.LibroService;

public class FactoryService {

    private static final IAutoreService I_AUTORE_SERVICE = new AutoreService();
    private static final IGenereService I_GENERE_SERVICE = new GenereService();
    private static final ILibroService I_LIBRO_SERVICE = new LibroService();

    public static IAutoreService getiAutoreService() {
        return I_AUTORE_SERVICE;
    }

    public static IGenereService getiGenereService() {
        return I_GENERE_SERVICE;
    }

    public static ILibroService getiLibroService() {
        return I_LIBRO_SERVICE;
    }

}
