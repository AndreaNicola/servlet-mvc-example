package controllers.edit;

import models.Autore;
import services.FactoryService;
import services.IAutoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorEdit", name = "AuthorEditServlet")
public class AuthorEditServlet extends HttpServlet {

    private static final IAutoreService I_AUTORE_SERVICE = FactoryService.getiAutoreService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        try {
            I_AUTORE_SERVICE.update(id, firstname, lastname);
            response.sendRedirect("/");
        } catch (Exception e) {
            String errore = e.getMessage() == null || e.getMessage().isEmpty() ? "Errore inatteso" : e.getMessage();
            request.setAttribute("action", "authorEdit");
            request.setAttribute("errore", errore);
            request.setAttribute("id", id);
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);

            request.getRequestDispatcher("/WEB-INF/jsp/form/authorForm.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));

        Autore autore = I_AUTORE_SERVICE.get(id);
        request.setAttribute("id", autore.getId());
        request.setAttribute("firstname", autore.getNome());
        request.setAttribute("lastname", autore.getCognome());
        request.setAttribute("action", "authorEdit");
        request.getRequestDispatcher("/WEB-INF/jsp/form/authorForm.jsp").forward(request, response);
    }
}
