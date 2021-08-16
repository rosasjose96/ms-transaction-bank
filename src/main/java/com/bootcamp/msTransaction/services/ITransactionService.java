package com.bootcamp.msTransaction.services;

import com.bootcamp.msTransaction.models.entities.Transaction;
import reactor.core.publisher.Flux;

public interface ITransactionService extends ICRUDService<Transaction,String> {
    Flux<Transaction> findAllByIdentityNumber(String identityNumber);
}
