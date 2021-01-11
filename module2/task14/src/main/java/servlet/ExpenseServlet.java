package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "expenseServlet", urlPatterns = "/task14")
public class ExpenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<html><head><title>expenseServlet</title></head>");
            ServletContext config = getServletContext();
            String url = config.getInitParameter("database.url");
            String username = config.getInitParameter("database.username");
            String password = config.getInitParameter("database.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(
                    "SELECT prod.expenses.id, prod.expenses.paydate, prod.receivers.receiver, prod.expenses.sum FROM prod.expenses, prod.receivers\n" +
                            "where prod.expenses.receiver = prod.receivers.id");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                Date date = resultSet.getDate(2);
                String name = resultSet.getString(3);
                int sum = resultSet.getInt(4);
                writer.println("<body><h1>" + id + " " + date + " " + name + " " + sum + "</h1>");
            }
            writer.println("</body></html>");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
