package com.rogerio.ApiControleFinanceiro.controller;

import com.rogerio.ApiControleFinanceiro.dto.TransactionCreateDTO;
import com.rogerio.ApiControleFinanceiro.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    final private TransactionService service;
    public TransactionController(TransactionService transactionService){
        this.service = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> transactionSave(@Valid @RequestBody TransactionCreateDTO transactionCreateDTO, UriComponentsBuilder uriComponentsBuilder){
        Long id = service.transactionSave(transactionCreateDTO);
        URI uri = uriComponentsBuilder.path("/transactions/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();

    }
}
