package tech.techsete.witetec_sdk.services;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tech.techsete.witetec_sdk.dtos.requests.WithdrawRequest;
import tech.techsete.witetec_sdk.dtos.responses.WithdrawResponse;

import java.util.Map;

/**
 * Serviço responsável por interagir com API de saques (Withdrawals) do Witetec.
 * <p>
 * A classe fornece funcionalidades para criar e consultar saques de forma síncrona e assíncrona,
 * utilizando {@link WebClient} para comunicação com APIs REST.
 * </p>
 *
 * <h2>Métodos disponíveis</h2>
 * <ul>
 *     <li>{@link #createWithdraw(Map, WithdrawRequest)}: Criação de saque de forma síncrona.</li>
 *     <li>{@link #createWithdrawAsync(Map, WithdrawRequest)}: Criação de saque de forma assíncrona.</li>
 *     <li>{@link #findById(Map, String)}: Consulta de um saque por ID de forma síncrona.</li>
 *     <li>{@link #findByIdAsync(Map, String)}: Consulta de um saque por ID de forma assíncrona.</li>
 * </ul>
 *
 * <p>
 * Esta classe é gerenciada pelo Spring, identificada como um {@code @Service}
 * com o nome {@code WitetecSDKWithdrawService}.
 * </p>
 *
 * @see WebClient
 * @see WithdrawRequest
 * @see WithdrawResponse
 */
@Service("WitetecSDKWithdrawService")
public class WithdrawService {

    private final WebClient webClient;

    /**
     * Construtor do serviço de saques.
     * <p>
     * Injeta o cliente {@link WebClient} configurado para se comunicar com as APIs
     * do Witetec.
     * </p>
     *
     * @param webClient O cliente {@code WebClient} configurado para as APIs do SDK.
     */
    public WithdrawService(@Qualifier("WitetecSDKWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Cria um novo saque de forma síncrona.
     *
     * @param headers  Cabeçalhos HTTP adicionais a serem incluídos na requisição.
     * @param request  A requisição {@link WithdrawRequest} com os detalhes do saque.
     * @return Um objeto {@link WithdrawResponse} com os detalhes do saque criado.
     * @see #createWithdrawAsync(Map, WithdrawRequest)
     */
    public WithdrawResponse createWithdraw(Map<String, ?> headers,
                                           @Valid WithdrawRequest request) {
        return createWithdrawAsync(headers, request).block();
    }

    /**
     * Cria um novo saque de forma assíncrona.
     * <p>
     * Este método utiliza {@link WebClient} para realizar a requisição HTTP POST
     * destinada à criação de novos saques.
     * </p>
     *
     * @param headers  Cabeçalhos HTTP adicionais a serem incluídos na requisição.
     * @param request  A requisição {@link WithdrawRequest} contendo os detalhes do saque.
     * @return Um {@link Mono} que emite o {@link WithdrawResponse}.
     * @see #createWithdraw(Map, WithdrawRequest)
     */
    public Mono<WithdrawResponse> createWithdrawAsync(Map<String, ?> headers,
                                                      @Valid WithdrawRequest request) {

        return webClient.post()
                .uri("//withdrawals")
                .headers(httpHeaders -> headers.forEach((key, value) -> httpHeaders.add(key, value.toString())))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(WithdrawResponse.class);
    }

    /**
     * Consulta um saque por ID de forma síncrona.
     *
     * @param headers  Cabeçalhos HTTP adicionais a serem incluídos na requisição.
     * @param id       O identificador único do saque a ser consultado.
     * @return Um objeto {@link WithdrawResponse} com os detalhes do saque.
     * @see #findByIdAsync(Map, String)
     */
    public WithdrawResponse findById(Map<String, ?> headers, String id) {
        return findByIdAsync(headers, id).block();
    }

    /**
     * Consulta os detalhes de um saque por ID de forma assíncrona.
     * <p>
     * Este método utiliza {@link WebClient} para realizar a requisição HTTP GET
     * destinada à recuperação dos detalhes do saque.
     * </p>
     *
     * @param headers  Cabeçalhos HTTP adicionais a serem incluídos na requisição.
     * @param id       O identificador único do saque a ser consultado.
     * @return Um {@link Mono} que emite o {@link WithdrawResponse} com os detalhes do saque.
     * @see #findById(Map, String)
     */
    public Mono<WithdrawResponse> findByIdAsync(Map<String, ?> headers, String id) {

        return webClient.get()
                .uri(String.format("/withdrawals/%s", id))
                .headers(httpHeaders -> headers.forEach((key, value) -> httpHeaders.add(key, value.toString())))
                .retrieve()
                .bodyToMono(WithdrawResponse.class);
    }
}