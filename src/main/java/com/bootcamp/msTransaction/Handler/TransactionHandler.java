package com.bootcamp.msTransaction.Handler;

import com.bootcamp.msTransaction.models.entities.Transaction;
import com.bootcamp.msTransaction.services.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * The type Transaction handler.
 */
@Component
public class TransactionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionHandler.class);

    @Autowired
    private ITransactionService service;

    /**
     * Find transactions by identity number mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> findTransactionsByIdentityNumber(ServerRequest request){
        String identityNumber = request.pathVariable("identityNumber");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAllByIdentityNumber(identityNumber), Transaction.class);
    }


    /**
     * Find all mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll(), Transaction.class);
    }

    /**
     * Find all commissions mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> findAllCommissions(ServerRequest request){
        String identityNumber = request.pathVariable("identityNumber");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(service.findAll().filter(transaction -> transaction.getTypeoftransaction().equals("COMMISSION")
                        && transaction.getIdentityNumber().equals(identityNumber))
                        , Transaction.class);
    }

    /**
     * New transaction mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> newTransaction(ServerRequest request){

        Mono<Transaction> transactionMono = request.bodyToMono(Transaction.class);

        return transactionMono.flatMap( Request -> service.create(Request))
                .flatMap( c -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(c)));
    }

    /**
     * Delete transaction mono.
     *
     * @param request the request
     * @return the mono
     */
    public Mono<ServerResponse> deleteTransaction(ServerRequest request){
        String id = request.pathVariable("id");
        return service.findById(id)
                .flatMap(service::delete)
                .then(ServerResponse.noContent().build());
    }
}
