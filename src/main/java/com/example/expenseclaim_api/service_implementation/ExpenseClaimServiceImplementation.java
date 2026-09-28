package com.example.expenseclaim_api.service_implementation;

import com.example.expenseclaim_api.model.ExpenseClaim;
import com.example.expenseclaim_api.repo.ExpenseClaimRepository;
import com.example.expenseclaim_api.service.ExpenseClaimService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseClaimServiceImplementation implements ExpenseClaimService {

    private final ExpenseClaimRepository repository;

    public ExpenseClaimServiceImplementation(ExpenseClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExpenseClaim createExpenseClaim(ExpenseClaim expenseClaim) {
        if (expenseClaim.getStatus() == null || expenseClaim.getStatus().isBlank()) {
            expenseClaim.setStatus("PENDING");
        }
        return repository.save(expenseClaim);
    }

    @Override
    public List<ExpenseClaim> getAllExpenseClaims() {
        return repository.findAll();
    }

    @Override
    public ExpenseClaim getExpenseClaimById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseClaim not found"));
    }

    @Override
    public ExpenseClaim updateExpenseClaim(Long id, ExpenseClaim expenseClaim) {
        ExpenseClaim existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseClaim not found"));

        existing.setEmployeeId(expenseClaim.getEmployeeId());
        existing.setTotalAmount(expenseClaim.getTotalAmount());
        existing.setStatus(expenseClaim.getStatus());
        existing.setClaimDate(expenseClaim.getClaimDate());
        return repository.save(existing);
    }

    @Override
    public void deleteExpenseClaim(Long id) {
        ExpenseClaim existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseClaim not found"));
        repository.delete(existing);
    }
}
