import java.sql.*;

public class Task5 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter parameters: args[0](date) - 'yyyy-MM-dd' args[1](receiver) - 1-3 args[2](sum) >=0");
        } else
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
            String username = "root";
            String password = "root";
            String template = "select * from test.expenses";
            String template1 = "select test.expenses.id, test.expenses.paydate, " +
                    "test.receivers.receive, test.expenses.sum " +
                    "from test.expenses, test.receivers " +
                    "where test.receivers.id_receive = test.expenses.receive and test.expenses.sum > ? ";

            final Connection connection = DriverManager.getConnection(dbUrl,
                    username,
                    password);

            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(template);

            int count = 0;

            while (resultSet.next()) {
                count++;
            }
            StringBuilder string = new StringBuilder("insert into test.expenses values (");
            string.append(String.valueOf(count + 1) + ", ");
            string.append(String.valueOf(args[0] + ", "));
            string.append(String.valueOf(args[1] + ", "));
            string.append(String.valueOf(args[2] + ")"));

            statement.executeUpdate(String.valueOf(string));

            PreparedStatement preparedStatement = connection.prepareStatement(template1);
            preparedStatement.setInt(1, 10000);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            while (resultSet1.next()) {
                System.out.println(resultSet1.getInt(1)
                        + " " + resultSet1.getDate(2)
                        + " " + resultSet1.getString(3)
                        + " " + resultSet1.getInt(4));
            }

            resultSet1.close();
            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
