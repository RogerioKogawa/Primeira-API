package com.rogerio.ApiControleFinanceiro.dto;

import com.rogerio.ApiControleFinanceiro.model.TipoTransacao;
import com.rogerio.ApiControleFinanceiro.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponseDTO(Long id, TipoTransacao tipo, String categoria, BigDecimal valor, LocalDateTime dataTransacao){
    public TransactionResponseDTO(Transaction transaction){
        this(
                transaction.getId(),
                transaction.getTipo(),
                transaction.getCategoria(),
                transaction.getValor(),
                transaction.getDataTransacao()
        );
    }
}