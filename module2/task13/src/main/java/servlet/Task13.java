package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "task13", urlPatterns = "/task13")
public class Task13 extends HttpServlet {
    static String fileName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count;
        String cookName = "task13";
        String cookValue = req.getSession().getId();

        fileName = getServletContext().getRealPath("file.txt");

        if (readCount() == null) {
            count = 0;
        } else {
            count = readCount();
        }

        Cookie[] myCookies = req.getCookies();
        for (Cookie cookies : myCookies) {
            if (!cookName.equals(cookies.getName()) && !cookValue.equals(cookies.getValue())) {
                count++;
                Cookie cookie = new Cookie(cookName, cookValue);
                cookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(cookie);
            }
        }

        writeCount(count);

        PrintWriter pw = resp.getWriter();
        pw.println("<h1>Number of unique visitors: " + count + "</h1>");
    }

    private static Integer readCount() {
        Integer count = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            count = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static void writeCount(int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(count + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

