package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ReceiverDaoImpl implements ReceiverDao {

    private Connection connection;

    public ReceiverDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Receiver receiver) {

    }

    @Override
    public Receiver read(int id) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("")){

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Receiver> readAll() {
        return null;
    }

    @Override
    public void update(Receiver receiver) {

    }

    @Override
    public void delete(Receiver receiver) {

    }
}
