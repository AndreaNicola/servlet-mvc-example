package controllers.insert;

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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/bookInsert", name = "BookInsertServlet")
public class BookInsertServlet extends HttpServlet {

    private static final IAutoreService I_AUTORE_SERVICE = FactoryService.getiAutoreService();
    private static final ILibroService I_LIBRO_SERVICE = FactoryService.getiLibroService();
    private static final IGenereService I_GENERE_SERVICE = FactoryService.getiGenereService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String selectedAuthor = request.getParameter("selectedAuthor");
        String[] selectedGenres = request.getParameterValues("selectedGenres");

        try {

            Long autoreId = Long.parseLong(selectedAuthor);
            List<Long> generi = Arrays.asList(selectedGenres).stream().map(Long::parseLong).collect(Collectors.toList());

            I_LIBRO_SERVICE.insert(title, description, autoreId, generi);
            response.sendRedirect("/");

        } catch (Exception e) {
            request.setAttribute("title", title);
            request.setAttribute("description", description);
            request.setAttribute("selectedAuthor", selectedAuthor);
            request.setAttribute("selectedGenres", selectedGenres);
            doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "bookInsert");
        request.setAttribute("generi", I_GENERE_SERVICE.list());
        request.setAttribute("autori", I_AUTORE_SERVICE.list());
        request.getRequestDispatcher("/WEB-INF/jsp/form/bookForm.jsp").forward(request, response);
    }
}
