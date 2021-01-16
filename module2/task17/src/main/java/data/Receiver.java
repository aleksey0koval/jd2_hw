package data;

public class Receiver {
    private int id;
    private String receiver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "id=" + id +
                ", receiver='" + receiver + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receiver receiver1 = (Receiver) o;

        if (id != receiver1.id) return false;
        return receiver != null ? receiver.equals(receiver1.receiver) : receiver1.receiver == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        return result;
    }
}
