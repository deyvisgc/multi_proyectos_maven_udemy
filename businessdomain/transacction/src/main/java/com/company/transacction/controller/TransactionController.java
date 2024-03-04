package com.company.transacction.controller;

import com.company.transacction.entities.TransactionEntity;
import com.company.transacction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class ProductController {
    @Autowired
    TransactionRepository transactionRepository;
    @GetMapping("/")
    public List<TransactionEntity> findAll() {
        return transactionRepository.findAll();
    }
    @GetMapping("/{id}")
    public TransactionEntity getByID(@PathVariable long id){
        return transactionRepository.findById(id).get();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TransactionEntity TransactionEntity) {
        TransactionEntity save = transactionRepository.save(TransactionEntity);
        return ResponseEntity.ok(save);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody TransactionEntity transactionEntity) {
        Optional<TransactionEntity> transaction = transactionRepository.findById(id);
        TransactionEntity save = new TransactionEntity();
        if (transaction.isPresent()) {
            TransactionEntity entity = TransactionEntity
                    .builder()
                    .reference(transactionEntity.getReference())
                    .accountIban(transactionEntity.getAccountIban())
                    .date(transactionEntity.getDate())
                    .amount(transactionEntity.getAmount())
                    .fee(transactionEntity.getFee())
                    .description(transactionEntity.getDescription())
                    .status(transactionEntity.getStatus())
                    .Channel(transactionEntity.getChannel())
                    .build();
            save = transactionRepository.save(entity);
        }
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<TransactionEntity> product = transactionRepository.findById(id);
        if (product.isPresent()) {
            transactionRepository.delete(product.get());
        }
        return ResponseEntity.ok().build();
    }
}
