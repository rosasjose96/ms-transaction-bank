package com.bootcamp.msTransaction.services;

import com.bootcamp.msTransaction.models.entities.TransactionActive;
import reactor.core.publisher.Flux;

public interface ITransactionService extends ICRUDService<TransactionActive,String> {
    Flux<TransactionActive> findAllByIdentityNumber(String identityNumber);
}
