package ru.korchinskiy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String title = "";
        String h1 = "";
        switch (resp.getStatus()) {
            case HttpServletResponse.SC_FORBIDDEN:
                title = "Error 403";
                h1 = "Forbidden";
                break;
            case HttpServletResponse.SC_NOT_FOUND:
                title = "Error 404";
                h1 = "Page not found";
                break;
        }
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + h1 + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
