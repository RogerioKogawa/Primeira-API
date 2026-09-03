package com.rogerio.ApiControleFinanceiro.repository;

import com.rogerio.ApiControleFinanceiro.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
