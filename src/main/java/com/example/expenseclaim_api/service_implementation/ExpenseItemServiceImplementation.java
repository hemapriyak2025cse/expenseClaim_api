package com.example.expenseclaim_api.service_implementation;

import com.example.expenseclaim_api.model.ExpenseItem;
import com.example.expenseclaim_api.repo.ExpenseItemRepository;
import com.example.expenseclaim_api.service.ExpenseItemService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseItemServiceImplementation implements ExpenseItemService {

    private final ExpenseItemRepository repository;

    public ExpenseItemServiceImplementation(ExpenseItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExpenseItem createExpenseItem(ExpenseItem expenseItem) {
        return repository.save(expenseItem);
    }

    @Override
    public List<ExpenseItem> getAllExpenseItems() {
        return repository.findAll();
    }

    @Override
    public ExpenseItem getExpenseItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseItem not found"));
    }

    @Override
    public ExpenseItem updateExpenseItem(Long id, ExpenseItem expenseItem) {
        ExpenseItem existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseItem not found"));

        existing.setClaimId(expenseItem.getClaimId());
        existing.setCategory(expenseItem.getCategory());
        existing.setAmount(expenseItem.getAmount());
        existing.setDescription(expenseItem.getDescription());
        return repository.save(existing);
    }

    @Override
    public void deleteExpenseItem(Long id) {
        ExpenseItem existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseItem not found"));
        repository.delete(existing);
    }
}
