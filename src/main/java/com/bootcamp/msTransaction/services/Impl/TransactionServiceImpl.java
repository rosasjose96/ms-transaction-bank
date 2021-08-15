package com.bootcamp.msTransaction.services.Impl;

import com.bootcamp.msTransaction.models.entities.TransactionActive;
import com.bootcamp.msTransaction.repositories.TransactionRepository;
import com.bootcamp.msTransaction.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private TransactionRepository repository;


    @Override
    public Mono<TransactionActive> create(TransactionActive o) {
        return repository.save(o);
    }

    @Override
    public Flux<TransactionActive> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<TransactionActive> findById(String s) {
        return repository.findById(s);
    }

    @Override
    public Mono<Void> delete(TransactionActive o) {
        return repository.delete(o);
    }

    @Override
    public Mono<TransactionActive> update(TransactionActive o) {
        return repository.save(o);
    }

    @Override
    public Flux<TransactionActive> findAllByIdentityNumber(String identityNumber) {
        return repository.findAllByIdentityNumber(identityNumber);
    }
}
