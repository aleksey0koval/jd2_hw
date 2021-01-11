package data;

public class Receiver {

    private int idRec;
    private String receiverRec;

    public Receiver() {
    }

    public int getIdRec() {
        return idRec;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }

    public String getReceiverRec() {
        return receiverRec;
    }

    public void setReceiverRec(String receiverRec) {
        this.receiverRec = receiverRec;
    }

    @Override
    public String toString() {
        return "Receivers{" +
                "id_receiver=" + idRec +
                ", receive='" + receiverRec + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receiver receivers = (Receiver) o;

        if (idRec != receivers.idRec) return false;
        return receiverRec != null ? receiverRec.equals(receivers.receiverRec) : receivers.receiverRec == null;
    }

    @Override
    public int hashCode() {
        int result = idRec;
        result = 31 * result + (receiverRec != null ? receiverRec.hashCode() : 0);
        return result;
    }
}
