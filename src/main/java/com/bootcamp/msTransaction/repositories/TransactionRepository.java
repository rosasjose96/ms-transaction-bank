package com.bootcamp.msTransaction.repositories;

import com.bootcamp.msTransaction.models.entities.TransactionActive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveMongoRepository<TransactionActive,String> {
    Flux<TransactionActive> findAllByIdentityNumber(String identityNumber);
}
