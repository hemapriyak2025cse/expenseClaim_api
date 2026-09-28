package com.example.expenseclaim_api.service;

import com.example.expenseclaim_api.model.ExpenseItem;
import java.util.List;

public interface ExpenseItemService {
    ExpenseItem createExpenseItem(ExpenseItem expenseItem);
    List<ExpenseItem> getAllExpenseItems();
    ExpenseItem getExpenseItemById(Long id);
    ExpenseItem updateExpenseItem(Long id, ExpenseItem expenseItem);
    void deleteExpenseItem(Long id);
}
