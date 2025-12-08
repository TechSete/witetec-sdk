package tech.techsete.witetec_sdk.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tech.techsete.witetec_sdk.dtos.requests.PixTransactionRequest;
import tech.techsete.witetec_sdk.dtos.responses.PixTransactionResponse;

import java.util.Map;

/**
 * Serviço responsável por gerenciar transações financeiras via PIX.
 * <p>
 * A classe fornece funcionalidades para criar e buscar transações de forma
 * síncrona e assíncrona, utilizando o {@link WebClient} para se comunicar
 * com APIs REST.
 * </p>
 *
 * <h2>Principais Funcionalidades</h2>
 * <ul>
 *     <li>{@link #createPixTransaction(Map, PixTransactionRequest)}: Criação de transação PIX (síncrono).</li>
 *     <li>{@link #createPixTransactionAsync(Map, PixTransactionRequest)}: Criação de transação PIX (assíncrono).</li>
 *     <li>{@link #findById(Map, String)}: Consultar transação PIX por ID (síncrono).</li>
 *     <li>{@link #findByIdAsync(Map, String)}: Consultar transação PIX por ID (assíncrono).</li>
 * </ul>
 *
 * <p>
 * Essa classe é gerenciada pelo Spring como um {@code @Service}, com o nome
 * {@code WitetecSDKTransactionService}. Ela depende de um {@link WebClient}
 * nomeado como {@code WitetecSDKWebClient} para comunicação com APIs externas.
 * </p>
 *
 * @see WebClient
 * @see PixTransactionRequest
 * @see PixTransactionResponse
 */
@Service("WitetecSDKTransactionService")
public class TransactionService {

    private final WebClient webClient;

    /**
     * Construtor do serviço de transações.
     * <p>
     * Injeta o {@link WebClient} configurado para gerenciar transações financeiras.
     * </p>
     *
     * @param webClient O cliente {@link WebClient} personalizado.
     */
    public TransactionService(@Qualifier("WitetecSDKWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Cria uma nova transação PIX de forma síncrona.
     *
     * @param headers Cabeçalhos HTTP adicionais a serem enviados na requisição.
     * @param request Objeto {@link PixTransactionRequest} contendo os dados da transação PIX.
     * @return Um objeto {@link PixTransactionResponse} com os detalhes da transação criada.
     * @see #createPixTransactionAsync(Map, PixTransactionRequest)
     */
    public PixTransactionResponse createPixTransaction(Map<String, ?> headers,
                                                       @Valid PixTransactionRequest request) {
        return createPixTransactionAsync(headers, request).block();
    }

    /**
     * Cria uma nova transação PIX de forma assíncrona.
     * <p>
     * Este método realiza uma chamada HTTP POST para criar uma nova transação
     * PIX e retorna imediatamente um {@link Mono} com a resposta da operação.
     * </p>
     *
     * @param headers Cabeçalhos HTTP adicionais a serem enviados na requisição.
     * @param request Objeto {@link PixTransactionRequest} contendo os dados da transação PIX.
     * @return Um {@link Mono} que emite o {@link PixTransactionResponse} quando concluído.
     * @see #createPixTransaction(Map, PixTransactionRequest)
     */
    public Mono<PixTransactionResponse> createPixTransactionAsync(Map<String, ?> headers,
                                                                  @Valid PixTransactionRequest request) {
        return webClient.post()
                .uri("/transactions")
                .headers(httpHeaders -> headers.forEach((key, value) -> httpHeaders.add(key, value.toString())))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(PixTransactionResponse.class);
    }

    /**
     * Consulta os detalhes de uma transação PIX por ID de forma síncrona.
     *
     * @param headers Cabeçalhos HTTP adicionais a serem enviados na requisição.
     * @param id      O identificador único da transação PIX.
     * @return Um objeto {@link PixTransactionResponse} contendo os detalhes da transação consultada.
     * @see #findByIdAsync(Map, String)
     */
    public PixTransactionResponse findById(Map<String, ?> headers, String id) {
        return findByIdAsync(headers, id).block();
    }

    /**
     * Consulta os detalhes de uma transação PIX por ID de forma assíncrona.
     * <p>
     * Este método realiza uma chamada HTTP GET para buscar os detalhes de uma
     * transação PIX específica e retorna imediatamente um {@link Mono} com os
     * dados da transação.
     * </p>
     *
     * @param headers Cabeçalhos HTTP adicionais a serem enviados na requisição.
     * @param id      O identificador único da transação PIX.
     * @return Um {@link Mono} que emite o {@link PixTransactionResponse} quando concluído.
     * @see #findById(Map, String)
     */
    public Mono<PixTransactionResponse> findByIdAsync(Map<String, ?> headers, String id) {
        return webClient.get()
                .uri(String.format("/transactions/%s", id))
                .headers(httpHeaders -> headers.forEach((key, value) -> httpHeaders.add(key, value.toString())))
                .retrieve()
                .bodyToMono(PixTransactionResponse.class);
    }
}