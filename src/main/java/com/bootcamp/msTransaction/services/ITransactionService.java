package com.bootcamp.msTransaction.services;

import com.bootcamp.msTransaction.models.entities.Transaction;
import reactor.core.publisher.Flux;

/**
 * The interface Transaction service.
 */
public interface ITransactionService extends ICRUDService<Transaction,String> {
    /**
     * Find all by identity number flux.
     *
     * @param identityNumber the identity number
     * @return the flux
     */
    Flux<Transaction> findAllByIdentityNumber(String identityNumber);
}
