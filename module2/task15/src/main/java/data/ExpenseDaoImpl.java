package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDaoImpl implements ExpenseDao {
    private Connection connection;

    public ExpenseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Expense read(int id) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM prod.expenses " +
                     "where prod.expenses.id = " + id)) {
            resultSet.next();
            Expense expense = new Expense();
            expense.setId(resultSet.getInt("id"));
            expense.setDate(resultSet.getDate("paydate"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setSum(resultSet.getInt("sum"));
            return expense;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Expense> readAll() {
        List<Expense> expenses = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM prod.expenses")) {
            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setId(resultSet.getInt("id"));
                expense.setDate(resultSet.getDate("paydate"));
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setSum(resultSet.getInt("sum"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public void create(Expense expense) {

    }

    @Override
    public void update(Expense expense) {

    }

    @Override
    public void delete(Expense expense) {

    }
}
