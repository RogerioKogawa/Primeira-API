package com.rogerio.ApiControleFinanceiro.service;
import com.rogerio.ApiControleFinanceiro.dto.TransactionCreateDTO;
import com.rogerio.ApiControleFinanceiro.dto.TransactionResponseDTO;
import com.rogerio.ApiControleFinanceiro.exception.ResourceNotFoundException;
import com.rogerio.ApiControleFinanceiro.model.Transaction;
import com.rogerio.ApiControleFinanceiro.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {


    private final TransactionRepository repository;

    public TransactionService(TransactionRepository transactionRepository){
        this.repository = transactionRepository;
    }

    @Transactional
    public Long transactionSave(TransactionCreateDTO transactionCreateDTO){
            Transaction transaction = new Transaction(transactionCreateDTO);
            repository.save(transaction);
            return transaction.getId();
    }

    public TransactionResponseDTO getTransaction(Long id){
        Transaction transaction = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transação não encontrada"));
        return new TransactionResponseDTO(transaction);
    }
}
