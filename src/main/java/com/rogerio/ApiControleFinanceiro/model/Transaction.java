package com.rogerio.ApiControleFinanceiro.model;

import com.rogerio.ApiControleFinanceiro.dto.TransactionCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Transaction{

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String descricao;
    @Enumerated(EnumType.STRING) private TipoTransacao tipo;
    private String categoria;
    private BigDecimal valor;
    @Column(insertable = false)
    private LocalDateTime dataTransacao;

    public Transaction(TransactionCreateDTO transactionCreateDTO){
        this.descricao = transactionCreateDTO.descricao();
        this.tipo = transactionCreateDTO.tipo();
        this.categoria = transactionCreateDTO.categoria();
        this.valor = transactionCreateDTO.valor();
    }
}
