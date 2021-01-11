package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "task10", urlPatterns = "/info")
public class Task10 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>task10</title></head>");
        try {
            String name = req.getParameter("name");
            if (name.equals("") || name.split(" ").length == 0) {
                throw new ServletException("We not entered name");
            }
            String tel = req.getParameter("tel");
            String email = req.getParameter("email");
            if (tel.equals("") && email.equals("")) {
                throw new ServletException("We not entered tel. number and email");
            }
            if (email.equals("")) {
                writer.println("<body><h1>Name: " + name + ", tel: " + tel + "</h1>");
            } else if (tel.equals("")) {
                writer.println("<body><h1>Name: " + name + ", email: " + email + "</h1>");
            } else {
                writer.println("<body><h1>Name: " + name + ", tel: " + tel + ", email: " + email + "</h1>");
            }
            writer.println("</body></html>");
        } catch (ServletException e) {
            e.printStackTrace();
            writer.println("<h1>Error: " + e.getMessage() + "</h1>");
            writer.println("</body></html>");
        }
    }
}
