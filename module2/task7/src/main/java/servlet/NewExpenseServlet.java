package servlet;

import data.DaoFactory;
import data.DatabaseName;
import data.Expenses;
import data.ExpensesDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "newExpenseServlet", urlPatterns = "/new-expenses")
public class NewExpenseServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        try {
            ExpensesDao expensesDao = daoFactory.getExpenseDao();
            Expenses expenses = new Expenses();

            expenses.setIdExp(Integer.parseInt(req.getParameter("test.idExp")));
            expenses.setPaydate(Date.valueOf(req.getParameter("test.paydate")));
            expenses.setReceiverExp(req.getParameter("test.receiverExp"));
            expenses.setSum(Integer.parseInt(req.getParameter("test.sum")));

            expensesDao.addExpenses(expenses);

            writer.println("<h1>New expenses" + expenses + " has been added.");
        } catch (Exception e) {
            e.printStackTrace();
            writer.println("<h1>Error: " + e.getMessage());
        }
    }
}
