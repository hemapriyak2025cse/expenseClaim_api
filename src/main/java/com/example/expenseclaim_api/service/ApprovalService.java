package com.example.expenseclaim_api.service;

import com.example.expenseclaim_api.model.Approval;
import java.util.List;

public interface ApprovalService {
    Approval createApproval(Approval approval);
    List<Approval> getAllApprovals();
    Approval getApprovalById(Long id);
    Approval updateApproval(Long id, Approval approval);
    void deleteApproval(Long id);
}
