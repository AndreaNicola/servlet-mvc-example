package services;

import services.impl.AutoreService;

public class FactoryService {

    private static final IAutoreService I_AUTORE_SERVICE = new AutoreService();

    public static IAutoreService getiAutoreService() {
        return I_AUTORE_SERVICE;
    }

}
