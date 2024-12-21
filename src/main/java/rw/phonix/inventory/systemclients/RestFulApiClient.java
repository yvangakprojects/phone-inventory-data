package rw.phonix.inventory.systemclients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import rw.phonix.inventory.Model.PhoneInventory;

@Slf4j
@Component
public class RestFulApiClient {
    private String urlResource;
    private final RestTemplate restTemplate;

    public RestFulApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PhoneInventory postInventoryData(PhoneInventory phoneInventory) {
        ResponseEntity<PhoneInventory> response = null;
        try {
            HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<PhoneInventory> request = new HttpEntity<>(phoneInventory, headers);
            response = restTemplate.postForEntity(urlResource,
                    request, PhoneInventory.class);
        } catch (RestClientException rce) {
            log.error("RestFulApiClient-postInventoryData threw rest client exception: {}", rce.getMessage(), rce);
        } catch (Exception ex) {
            log.error("RestFulApiClient-postInventoryData threw exception: {}", ex.getMessage(), ex);

        }
        return response != null ? response.getBody() : null;
    }
}
