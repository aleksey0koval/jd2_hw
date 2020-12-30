import java.sql.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter parameters: args[0](date) - 'yyyy-MM-dd' args[1](receiver) - 1-3 args[2](sum) >=0");
        } else
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                final Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test?serverTimezone=UTC",
                        "root",
                        "root"
                );
                final Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from test.expenses");
                ResultSet resultSet1 = statement.executeQuery("select test.expenses.id, test.expenses.paydate, " +
                        "test.receivers.receive, test.expenses.sum " +
                        "from test.expenses, test.receivers " +
                        "where test.receivers.id_receive = test.expenses.receive");

                int count = 0;
                while (resultSet.next()) {
                    count++;
                }
                StringBuilder stringBuilder = new StringBuilder("insert into test.expenses values (");
                stringBuilder.append(String.valueOf(count + 1) + ", ");
                stringBuilder.append(String.valueOf(args[0] + ", "));
                stringBuilder.append(String.valueOf(args[1] + ", "));
                stringBuilder.append(String.valueOf(args[2] + ")"));

                statement.executeUpdate(String.valueOf(stringBuilder));

                while (resultSet1.next()) {
                    System.out.println(resultSet1.getInt(1)
                            + " " + resultSet1.getDate(2)
                            + " " + resultSet1.getString(3)
                            + " " + resultSet1.getInt(4));
                }
                resultSet.close();
                resultSet1.close();
                statement.close();
                connection.close();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
    }
}
