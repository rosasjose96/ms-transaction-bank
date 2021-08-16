package com.bootcamp.msTransaction.repositories;

import com.bootcamp.msTransaction.models.entities.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction,String> {
    Flux<Transaction> findAllByIdentityNumber(String identityNumber);
}
