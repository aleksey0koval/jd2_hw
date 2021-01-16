package servlet;

import data.*;

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
import java.util.Collections;
import java.util.List;

@WebServlet(name = "expenseServlet", urlPatterns = "/task17")
public class ExpenseServlet extends HttpServlet {
    DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final String databaseName = config.getServletContext().getInitParameter("database.name");
        try {
            daoFactory = DaoFactory.getInstance(DatabaseName.valueOf(databaseName));
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServletContext config = getServletContext();
            String url = config.getInitParameter("database.url");
            String username = config.getInitParameter("database.username");
            String password = config.getInitParameter("database.password");
            ExpenseDao expenseDao = daoFactory.getExpenseDao(url, username, password);

            final List<Expense> expenses;

            String id = req.getParameter("id");
            if (id == null) {
                expenses = expenseDao.readAll();
            } else {
                Expense expense = null;
                try {
                    expense = expenseDao.read(Integer.parseInt(id));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                expenses = expense != null ? List.of(expense) : Collections.emptyList();
            }

            req.setAttribute("expense", expenses);
            req.getRequestDispatcher("/task17.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
