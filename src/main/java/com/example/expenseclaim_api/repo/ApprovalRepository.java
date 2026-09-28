package com.example.expenseclaim_api.repo;

import com.example.expenseclaim_api.model.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
}
