package controllers;

import services.FactoryService;
import services.IAutoreService;
import services.impl.AutoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/author", name = "AuthorServlet")
public class AuthorServlet extends HttpServlet {

    private final static IAutoreService AUTORE_SERVICE = FactoryService.getiAutoreService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("autore", AUTORE_SERVICE.get(id));
        request.getRequestDispatcher("/WEB-INF/jsp/author.jsp").forward(request,response);
    }
}
