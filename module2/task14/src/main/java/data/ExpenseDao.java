package data;

import java.util.List;

public interface ExpenseDao {

    void create(Expense expense);

    Expense read(int id);

    List<Expense> readAll();

    void update(Expense expense);

    void delete(Expense expense);
}
