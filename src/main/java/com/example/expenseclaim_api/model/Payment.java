package com.example.expenseclaim_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Claim ID is required")
    private Long claimId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private Double amount;

    private String paymentReference;
    private LocalDate paymentDate;
    private String status;

    public Payment() {}
    public Payment(Long id, Long claimId, Double amount, String paymentReference, LocalDate paymentDate, String status) {
        this.id = id; 
        this.claimId = claimId;
         this.amount = amount;
        this.paymentReference = paymentReference; 
        this.paymentDate = paymentDate; 
        this.status = status;
    }
    public Long getId() { 
        return id; }
    public void setId(Long id) { 
        this.id = id;
     }
    public Long getClaimId() {
         return claimId; }
    public void setClaimId(Long claimId) {
         this.claimId = claimId; }
    public Double getAmount() {
         return amount; }
    public void setAmount(Double amount) { 
        this.amount = amount; }
    public String getPaymentReference() { 
        return paymentReference; }
    public void setPaymentReference(String paymentReference) {
         this.paymentReference = paymentReference; }
    public LocalDate getPaymentDate() { 
        return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { 
        this.paymentDate = paymentDate; }
    public String getStatus() {
         return status; }
    public void setStatus(String status) {
         this.status = status; }
}
