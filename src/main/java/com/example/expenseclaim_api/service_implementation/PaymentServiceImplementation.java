package com.example.expenseclaim_api.service_implementation;

import com.example.expenseclaim_api.model.Payment;
import com.example.expenseclaim_api.repo.PaymentRepository;
import com.example.expenseclaim_api.service.PaymentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentServiceImplementation implements PaymentService {

    private final PaymentRepository repository;

    public PaymentServiceImplementation(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        if (payment.getStatus() == null || payment.getStatus().isBlank()) {
            payment.setStatus("PENDING");
        }
        return repository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Payment existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        existing.setClaimId(payment.getClaimId());
        existing.setAmount(payment.getAmount());
        existing.setPaymentReference(payment.getPaymentReference());
        existing.setPaymentDate(payment.getPaymentDate());
        existing.setStatus(payment.getStatus());
        return repository.save(existing);
    }

    @Override
    public void deletePayment(Long id) {
        Payment existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        repository.delete(existing);
    }
}
