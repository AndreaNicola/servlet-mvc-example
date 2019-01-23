package controllers;

import services.FactoryService;
import services.IAutoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/index", "" , "/"}, name = "IndexServlet")
public class IndexServlet extends HttpServlet {

    private static IAutoreService autoreService = FactoryService.getiAutoreService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("autori", autoreService.list());
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
    }

}