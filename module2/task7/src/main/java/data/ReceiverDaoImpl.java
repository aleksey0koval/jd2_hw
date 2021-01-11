package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceiverDaoImpl implements ReceiverDao {

    private final Connection connection;

    public ReceiverDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Receiver readReceiver(int id) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM test.receivers where id=" + id)) {
            resultSet.next();
            Receiver receiver = new Receiver();
            receiver.setIdRec(resultSet.getInt("id"));
            receiver.setReceiverRec(resultSet.getString("receiver"));
            return receiver;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Receiver> readAllReceivers() {
        List<Receiver> receivers = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM test.receivers")
        ) {
            while (resultSet.next()) {
                Receiver receiver = new Receiver();
                receiver.setIdRec(resultSet.getInt("id"));
                receiver.setReceiverRec(resultSet.getString("receiver"));
                receivers.add(receiver);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receivers;
    }

    @Override
    public void addReceiver(Receiver receiver) {
        try (final PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into test.receivers (id, receiver) values(?, ?)")
        ) {
            preparedStatement.setInt(1, receiver.getIdRec());
            preparedStatement.setString(2, receiver.getReceiverRec());
            System.out.println("Added= " + preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

