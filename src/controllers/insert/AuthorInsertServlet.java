package controllers.insert;

import services.FactoryService;
import services.IAutoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorInsert", name = "AuthorInsertServlet")
public class AuthorInsertServlet extends HttpServlet {

    private static final IAutoreService I_AUTORE_SERVICE = FactoryService.getiAutoreService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        try {
            I_AUTORE_SERVICE.insert(firstname, lastname);
            response.sendRedirect("/");
        } catch (Exception e) {
            String errore = e.getMessage() == null || e.getMessage().isEmpty() ? "Errore inatteso" : e.getMessage();
            request.setAttribute("action", "authorInsert");
            request.setAttribute("errore", errore);
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);

            request.getRequestDispatcher("/WEB-INF/jsp/form/authorForm.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "authorInsert");
        request.getRequestDispatcher("/WEB-INF/jsp/form/authorForm.jsp").forward(request, response);
    }
}
