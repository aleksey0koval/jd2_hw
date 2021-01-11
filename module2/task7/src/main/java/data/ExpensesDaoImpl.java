package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao {

    private final Connection connection;

    public ExpensesDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Expenses readExpense(int idExp) {
        try (final Statement statement = connection.createStatement();
             final ResultSet resultSet = statement.executeQuery("SELECT * FROM test.expenses where id=" + idExp);
        ) {
            resultSet.next();
            Expenses expenses = new Expenses();
            expenses.setIdExp(resultSet.getInt("id"));
            expenses.setPaydate(resultSet.getDate("paydate"));
            expenses.setReceiverExp(resultSet.getString("receiver"));
            expenses.setSum(resultSet.getInt("sum"));
            return expenses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Expenses> readAllExpenses() {
        List<Expenses> expenses = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from test.expenses");
        ) {
            while (resultSet.next()) {
                Expenses expense = new Expenses();
                expense.setIdExp(resultSet.getInt("id"));
                expense.setPaydate(resultSet.getDate("paydate"));
                expense.setReceiverExp(resultSet.getString("receiver"));
                expense.setSum(resultSet.getInt("sum"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public void addExpenses(Expenses expenses) {
        try (final PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into test.expenses (id, paydate, receiver, sum) values(?,?,?,?)")
        ) {
            preparedStatement.setInt(1, expenses.getIdExp());
            preparedStatement.setDate(2, expenses.getPaydate());
            preparedStatement.setString(3, expenses.getReceiverExp());
            preparedStatement.setInt(4, expenses.getSum());
            System.out.println("Added= " + preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
