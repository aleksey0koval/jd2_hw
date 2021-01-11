package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServ", urlPatterns = "/task9")
public class MyServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter pr = resp.getWriter();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                pr.print("Hubochka-Bubochka ");

            }
            pr.println("<p1><big><big><big><big><big><big><big><big><big><big><big><big>" +
                    "Lukashenko loh </big></big></big></big></big></big></big></big></big></big></big></big></p1>");

        }
    }
}
