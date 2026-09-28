package com.example.expenseclaim_api.service_implementation;

import com.example.expenseclaim_api.model.Approval;
import com.example.expenseclaim_api.repo.ApprovalRepository;
import com.example.expenseclaim_api.service.ApprovalService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalServiceImplementation implements ApprovalService {

    private final ApprovalRepository repository;

    public ApprovalServiceImplementation(ApprovalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Approval createApproval(Approval approval) {
        if (approval.getStatus() == null || approval.getStatus().isBlank()) {
            approval.setStatus("PENDING");
        }
        return repository.save(approval);
    }

    @Override
    public List<Approval> getAllApprovals() {
        return repository.findAll();
    }

    @Override
    public Approval getApprovalById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval not found"));
    }

    @Override
    public Approval updateApproval(Long id, Approval approval) {
        Approval existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval not found"));

        existing.setClaimId(approval.getClaimId());
        existing.setManagerName(approval.getManagerName());
        existing.setStatus(approval.getStatus());
        existing.setComments(approval.getComments());
        existing.setApprovalDate(approval.getApprovalDate());
        return repository.save(existing);
    }

    @Override
    public void deleteApproval(Long id) {
        Approval existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Approval not found"));
        repository.delete(existing);
    }
}
