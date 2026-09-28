package com.example.expenseclaim_api.controller;

import com.example.expenseclaim_api.model.Approval;
import com.example.expenseclaim_api.service.ApprovalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    private final ApprovalService service;

    public ApprovalController(ApprovalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Approval> createApproval(@Valid @RequestBody Approval item) {
        return new ResponseEntity<>(service.createApproval(item),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Approval>> getAllApprovals() {
        return new ResponseEntity<>(service.getAllApprovals(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approval> getApprovalById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getApprovalById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approval> updateApproval(@PathVariable Long id, @Valid @RequestBody Approval item) {
        return new ResponseEntity<>(service.updateApproval(id, item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApproval(@PathVariable Long id) {
        service.deleteApproval(id);
        return new ResponseEntity<>("Approval deleted successfully", HttpStatus.OK);
    }
}
