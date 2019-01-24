package controllers.insert;

import dao.FactoryDao;
import dao.IAutoreDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bookInsert", name = "BookInsertServlet")
public class BookInsertServlet extends HttpServlet {

    private static final IAutoreDao I_AUTORE_DAO = FactoryDao.getiAutoreDao();
    private static final I

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object genres = request.getParameter("genres");


        request.getRequestDispatcher("/WEB-INF/jsp/form/bookForm.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "bookInsert");
        request.getRequestDispatcher("/WEB-INF/jsp/form/bookForm.jsp").forward(request, response);
    }
}
