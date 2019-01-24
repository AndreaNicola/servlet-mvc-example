package controllers.details;

import models.Genere;
import models.Libro;
import services.FactoryService;
import services.IGenereService;
import services.ILibroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/genre", name = "GenreServlet")
public class GenreServlet extends HttpServlet {

    private static final ILibroService I_LIBRO_SERVICE = FactoryService.getiLibroService();
    private static final IGenereService I_GENERE_SERVICE = FactoryService.getiGenereService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Genere genere = I_GENERE_SERVICE.get(id);
        Collection<Libro> libri = I_LIBRO_SERVICE.listByGenere(id);

        request.setAttribute("genere", genere);
        request.setAttribute("libri", libri);

        request.getRequestDispatcher("/WEB-INF/jsp/genre.jsp").forward(request, response);

    }
}
