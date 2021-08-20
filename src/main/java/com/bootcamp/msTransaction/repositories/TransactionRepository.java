package com.bootcamp.msTransaction.repositories;

import com.bootcamp.msTransaction.models.entities.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * The interface Transaction repository.
 */
public interface TransactionRepository extends ReactiveMongoRepository<Transaction,String> {
    /**
     * Find all by identity number flux.
     *
     * @param identityNumber the identity number
     * @return the flux
     */
    Flux<Transaction> findAllByIdentityNumber(String identityNumber);
}
