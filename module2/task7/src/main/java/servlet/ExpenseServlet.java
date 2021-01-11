package servlet;

import data.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "expensesServlet", urlPatterns = "/expenses")
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
            String id = req.getParameter("id");
            final List<Expenses> expensesList;
            ExpensesDao expensesDao = daoFactory.getExpenseDao();
            if (id == null) {
                expensesList = expensesDao.readAllExpenses();
            } else {
                Expenses expenses = null;
                try {
                    expenses = expensesDao.readExpense(Integer.parseInt(id));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                expensesList = expenses != null ? List.of(expenses) : Collections.emptyList();
            }


            resp.setContentType("text/html; charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<html><head><title>expensesServlet</title></head>");

            for (Expenses expenses : expensesList) {
                System.out.println("id " + expenses.getIdExp() + " date " + expenses.getPaydate() +
                        " receiver " + expenses.getReceiverExp() + " summa " + expenses.getSum());

                writer.println("<body><h1>id " + expenses.getIdExp() + " date " + expenses.getPaydate() +
                        " receiver " + expenses.getReceiverExp() + " summa " + expenses.getSum() + "</h1>");
                writer.println("</body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
