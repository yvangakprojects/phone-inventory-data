package rw.phonix.inventory.systemclients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import rw.phonix.inventory.Model.PhoneInventory;
import rw.phonix.inventory.exception.ClientErrorException;

@Slf4j
@Component
public class RestFulApiClient {
    @Value("${restful.api.url}")
    private String urlResource;
    private final WebClient webClient;

    public RestFulApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PhoneInventory> postPhoneInventoryDataToExternalApi(PhoneInventory phoneInventory) {
        return webClient.post()
                .uri(urlResource)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(phoneInventory)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        clientResponse -> Mono.error(new ClientErrorException("Client Error", clientResponse)))
                .bodyToMono(PhoneInventory.class)
                .onErrorResume(Exception.class, e ->
                        Mono.error(new RuntimeException("RestFulApiClient - postPhoneInventoryDataToExternalApi: Error fetching data: " + e.getMessage())));
    }
}
