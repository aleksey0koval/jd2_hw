package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "task9", urlPatterns = "/task9")
public class Task9 extends HttpServlet {

    static String fileName;
    private static final long serialVersionUID = 1l;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        fileName = getServletContext().getRealPath("file.txt");
        int count;

        if (readCount() == null) {
            count = 0;
        } else {
            count = readCount();
        }

        count++;

        writeCount(count);

        pw.println("<h1>Count " + count);

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
