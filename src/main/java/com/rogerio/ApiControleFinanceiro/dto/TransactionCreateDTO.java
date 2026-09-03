package com.rogerio.ApiControleFinanceiro.dto;

import com.rogerio.ApiControleFinanceiro.model.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


public record TransactionCreateDTO(@NotBlank String descricao,
                             @NotNull TipoTransacao tipo,
                             @NotBlank String categoria,
                             @NotNull @Positive BigDecimal valor
){}
