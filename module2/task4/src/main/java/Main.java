import java.sql.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter parameters: args[0](date) - yyyy-mm-dd args[1](receiver) - 1-3 args[2](sum) >=0");

        } else if (Pattern.matches("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" +
                "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" +
                "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$", args[0]) == false) {
            System.out.println("vi vveli ne provilno datu libo takoi daty netu. Format: yyyy-mm-dd");

        } else if (Integer.parseInt(args[1]) > 3 || Integer.parseInt(args[1]) <= 0) {
            System.out.println("vvedite poluchateley args[1]:\n" +
                    "1 - internet-provaider \"Solo\"\n" +
                    "2 - gipermarket \"Korona\"\n" +
                    "3 - MTC");

        } else if (Integer.parseInt(args[2]) < 0) {
            System.out.println("Summa platezha (args[2]) ne mozhet byt` men`she 0");

        } else if (Pattern.matches("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" +
                "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" +
                "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$", args[0]) == true
                && Integer.parseInt(args[1]) > 0 && Integer.parseInt(args[1]) < 4
                && Integer.parseInt(args[2]) >= 0) {
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
                statement.executeUpdate("insert into test.expenses values (" + (count + 1) + ", '" +
                        args[0] + "', " + args[1] + ", " + args[2] + ")");

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
        } else {
            try {
                Integer.parseInt(args[1]);
                Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("vi vvodite ne chisla");
            }
        }
    }
}
