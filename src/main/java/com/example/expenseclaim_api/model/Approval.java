package com.example.expenseclaim_api.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Approval {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Claim ID is required")
    private Long claimId;

    private String managerName;
    private String status;
    private String comments;
    private LocalDate approvalDate;

    public Approval() {}
    public Approval(Long id, Long claimId, String managerName, String status, String comments, LocalDate approvalDate) {
        this.id = id;
        this.claimId = claimId;
        this.managerName = managerName;
        this.status = status; 
        this.comments = comments;
        this.approvalDate = approvalDate;
    }
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    public Long getClaimId() {
         return claimId; 
        }
    public void setClaimId(Long claimId) { 
        this.claimId = claimId;
     }
    public String getManagerName() { 
        return managerName; 
    }
    public void setManagerName(String managerName) { 
        this.managerName = managerName;
     }
    public String getStatus() {
         return status; 
        }
    public void setStatus(String status) {
         this.status = status; 
        }
    public String getComments() {
         return comments;
         }
    public void setComments(String comments) {
         this.comments = comments;
         }
    public LocalDate getApprovalDate() {
         return approvalDate; 
        }
    public void setApprovalDate(LocalDate approvalDate) {
         this.approvalDate = approvalDate; 
        }
}
