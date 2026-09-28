package com.example.expenseclaim_api.controller;

import com.example.expenseclaim_api.model.ExpenseClaim;
import com.example.expenseclaim_api.service.ExpenseClaimService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/expense-claims")
public class ExpenseClaimController {

    private final ExpenseClaimService service;

    public ExpenseClaimController(ExpenseClaimService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpenseClaim> createExpenseClaim(@Valid @RequestBody ExpenseClaim item) {
        return new ResponseEntity<>(service.createExpenseClaim(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseClaim>> getAllExpenseClaims() {
        return new ResponseEntity<>(service.getAllExpenseClaims(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseClaim> getExpenseClaimById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getExpenseClaimById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseClaim> updateExpenseClaim(@PathVariable Long id, @Valid @RequestBody ExpenseClaim item) {
        return new ResponseEntity<>(service.updateExpenseClaim(id, item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseClaim(@PathVariable Long id) {
        service.deleteExpenseClaim(id);
        return new ResponseEntity<>("Expense claim deleted successfully", HttpStatus.OK);
    }
}
