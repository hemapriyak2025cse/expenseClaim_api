package com.example.expenseclaim_api.controller;

import com.example.expenseclaim_api.model.ExpenseItem;
import com.example.expenseclaim_api.service.ExpenseItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/expense-items")
public class ExpenseItemController {

    private final ExpenseItemService service;

    public ExpenseItemController(ExpenseItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ExpenseItem> createExpenseItem(@Valid @RequestBody ExpenseItem item) {
        return new ResponseEntity<>(service.createExpenseItem(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseItem>> getAllExpenseItems() {
        return new ResponseEntity<>(service.getAllExpenseItems(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseItem> getExpenseItemById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getExpenseItemById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseItem> updateExpenseItem(@PathVariable Long id, @Valid @RequestBody ExpenseItem item) {
        return new ResponseEntity<>(service.updateExpenseItem(id, item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseItem(@PathVariable Long id) {
        service.deleteExpenseItem(id);
        return new ResponseEntity<>("Expense item deleted successfully", HttpStatus.OK);
    }
}
