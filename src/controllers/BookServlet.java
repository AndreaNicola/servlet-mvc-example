package controllers;

import models.Autore;
import models.Genere;
import models.Libro;
import services.FactoryService;
import services.IAutoreService;
import services.IGenereService;
import services.ILibroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/book", name = "BookServlet")
public class BookServlet extends HttpServlet {

    private static final ILibroService I_LIBRO_SERVICE = FactoryService.getiLibroService();
    private static final IGenereService I_GENERE_SERVICE = FactoryService.getiGenereService();
    private static final IAutoreService I_AUTORE_SERVICE = FactoryService.getiAutoreService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Libro libro = I_LIBRO_SERVICE.get(id);
        Autore autore = I_AUTORE_SERVICE.get(libro.getAutoreId());
        Collection<Genere> generi = I_GENERE_SERVICE.listByLibro(id);

        request.setAttribute("libro", libro);
        request.setAttribute("autore", autore);
        request.setAttribute("generi", generi);

        request.getRequestDispatcher("/WEB-INF/jsp/book.jsp").forward(request, response);
    }
}
