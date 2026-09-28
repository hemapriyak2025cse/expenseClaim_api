package com.example.expenseclaim_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
public class ExpenseClaim {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Employee ID is required")
    private Long employeeId;

    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    private Double totalAmount;

    private String status;

    @NotNull(message = "Claim date is required")
    private LocalDate claimDate;

    public ExpenseClaim() {}
    public ExpenseClaim(Long id, Long employeeId, Double totalAmount, String status, LocalDate claimDate) {
        this.id = id;
         this.employeeId = employeeId;
          this.totalAmount = totalAmount;
        this.status = status;
         this.claimDate = claimDate;
    }
    public Long getId() {
        return id; }
    public void setId(Long id) {
         this.id = id; }
    public Long getEmployeeId() {
         return employeeId; }
    public void setEmployeeId(Long employeeId) {
         this.employeeId = employeeId; }
    public Double getTotalAmount() {
         return totalAmount; }
    public void setTotalAmount(Double totalAmount) {
         this.totalAmount = totalAmount; }
    public String getStatus() {
         return status; }
    public void setStatus(String status) {
         this.status = status; }
    public LocalDate getClaimDate() {
         return claimDate; }
    public void setClaimDate(LocalDate claimDate) { 
        this.claimDate = claimDate; }
}
