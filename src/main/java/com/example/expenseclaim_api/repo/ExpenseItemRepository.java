package com.example.expenseclaim_api.repo;

import com.example.expenseclaim_api.model.ExpenseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseItemRepository extends JpaRepository<ExpenseItem, Long> {
}
