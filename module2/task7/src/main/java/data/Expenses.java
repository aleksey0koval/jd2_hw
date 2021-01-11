package data;

import java.sql.Date;

public class Expenses {

    private int idExp;
    private Date paydate;
    private String receiverExp;
    private int sum;

    public Expenses() {
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getReceiverExp() {
        return receiverExp;
    }

    public void setReceiverExp(String receiverExp) {
        this.receiverExp = receiverExp;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + idExp +
                ", paydate=" + paydate +
                ", receiver='" + receiverExp + '\'' +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expenses expenses = (Expenses) o;

        if (idExp != expenses.idExp) return false;
        if (sum != expenses.sum) return false;
        if (paydate != null ? !paydate.equals(expenses.paydate) : expenses.paydate != null) return false;
        return receiverExp != null ? receiverExp.equals(expenses.receiverExp) : expenses.receiverExp == null;
    }

    @Override
    public int hashCode() {
        int result = idExp;
        result = 31 * result + (paydate != null ? paydate.hashCode() : 0);
        result = 31 * result + (receiverExp != null ? receiverExp.hashCode() : 0);
        result = 31 * result + sum;
        return result;
    }
}
