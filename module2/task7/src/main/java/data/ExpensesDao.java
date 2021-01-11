package data;

import java.util.List;

public interface ExpensesDao {

    Expenses readExpense(int id);

    List<Expenses> readAllExpenses();

    void addExpenses(Expenses expenses);
}
