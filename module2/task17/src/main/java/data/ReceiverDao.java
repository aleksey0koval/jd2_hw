package data;

import java.util.List;

public interface ReceiverDao {

    void create(Receiver receiver);

    Receiver read(int id);

    List<Receiver> readAll();

    void update(Receiver receiver);

    void delete(Receiver receiver);



}
