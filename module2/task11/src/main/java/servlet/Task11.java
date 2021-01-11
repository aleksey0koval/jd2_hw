package servlet;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "task11", urlPatterns = "/task11")
public class Task11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>task11</title></head>");

        UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
        writer.println("<body><h1>Приветствую пользователя " + userAgent.getBrowser().getName() + "</h1>");
        writer.println("</body></html>");
    }
}
