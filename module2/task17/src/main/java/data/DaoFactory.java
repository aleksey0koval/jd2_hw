package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public ExpenseDao getExpenseDao(String url, String name, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, name, password);
        return new ExpenseDaoImpl(connection);
    }

    public static DaoFactory getInstance(DatabaseName databaseName) throws ClassNotFoundException {
        switch (databaseName) {
            case MYSQL: {
                if (daoFactory == null) {
                    daoFactory = new DaoFactory();
                }
                return daoFactory;
            }case ORAClE:{
                return null;
            }
        }
        throw new IllegalArgumentException("Database name is unknown");
    }
}
