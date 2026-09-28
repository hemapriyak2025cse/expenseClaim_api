package com.example.expenseclaim_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class ExpenseItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Claim ID is required")
    private Long claimId;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotBlank(message = "Description is required")
    private String description;

    public ExpenseItem() {}
    public ExpenseItem(Long id, Long claimId, String category, Double amount, String description) {
        this.id = id; 
        this.claimId = claimId;
         this.category = category;
        this.amount = amount; 
        this.description = description;
    }
    public Long getId() { 
        return id; }
    public void setId(Long id) { 
        this.id = id; }
    public Long getClaimId() { 
        return claimId; }
    public void setClaimId(Long claimId) {
         this.claimId = claimId; }
    public String getCategory() {
         return category; }
    public void setCategory(String category) {
         this.category = category; }
    public Double getAmount() {
         return amount; }
    public void setAmount(Double amount) {
         this.amount = amount; }
    public String getDescription() { 
        return description; }
    public void setDescription(String description) {
         this.description = description; }
}
