package com.example.expenseclaim_api.service;

import com.example.expenseclaim_api.model.ExpenseClaim;
import java.util.List;

public interface ExpenseClaimService {
    ExpenseClaim createExpenseClaim(ExpenseClaim expenseClaim);
    List<ExpenseClaim> getAllExpenseClaims();
    ExpenseClaim getExpenseClaimById(Long id);
    ExpenseClaim updateExpenseClaim(Long id, ExpenseClaim expenseClaim);
    void deleteExpenseClaim(Long id);
}
