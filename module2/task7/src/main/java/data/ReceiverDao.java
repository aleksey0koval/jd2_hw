package data;

import java.util.List;

public interface ReceiverDao {

    Receiver readReceiver(int id_receiver);

    List<Receiver> readAllReceivers();

    void addReceiver(Receiver receiver);
}
