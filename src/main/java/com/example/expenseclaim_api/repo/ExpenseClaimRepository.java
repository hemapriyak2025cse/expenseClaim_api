package com.example.expenseclaim_api.repo;

import com.example.expenseclaim_api.model.ExpenseClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Long> {
}
