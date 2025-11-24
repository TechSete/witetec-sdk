package tech.techsete.witetec_sdk.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tech.techsete.witetec_sdk.dtos.requests.PixTransactionRequest;
import tech.techsete.witetec_sdk.dtos.responses.PixTransactionResponse;

import java.util.Map;

@Service("WitetecSDKTransactionService")
public class TransactionService {

    private final WebClient webClient;

    public TransactionService(@Qualifier("WitetecSDKWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    public PixTransactionResponse createPixTransaction(Map<String, ?> headers,
                                                       @Valid PixTransactionRequest request) {
        return createPixTransactionAsync(headers, request).block();
    }

    public Mono<PixTransactionResponse> createPixTransactionAsync(Map<String, ?> headers,
                                                                  @Valid PixTransactionRequest request) {
        return webClient.post()
                .uri("/transactions")
                .headers(httpHeaders -> headers.forEach((key, value) -> httpHeaders.add(key, value.toString())))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(PixTransactionResponse.class);
    }

    public PixTransactionResponse findById(Map<String, ?> headers, String id) {
        return findByIdAsync(headers, id).block();
    }

    public Mono<PixTransactionResponse> findByIdAsync(Map<String, ?> headers, String id) {

        return webClient.get()
                .uri(String.format("/transactions/%s", id))
                .headers(httpHeaders -> headers.forEach((key, value) -> httpHeaders.add(key, value.toString())))
                .retrieve()
                .bodyToMono(PixTransactionResponse.class);
    }
}
