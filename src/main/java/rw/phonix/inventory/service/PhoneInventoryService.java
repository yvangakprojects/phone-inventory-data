package rw.phonix.inventory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import rw.phonix.inventory.Model.PhoneInventory;
import rw.phonix.inventory.systemclients.RestFulApiClient;

@Service
@Slf4j
public class PhoneInventoryService {

    private final RestFulApiClient restFulApiClient;

    public PhoneInventoryService(RestFulApiClient restFulApiClient) {
        this.restFulApiClient = restFulApiClient;
    }

    public Mono<PhoneInventory> saveInventory(PhoneInventory phoneInventory) {
        log.info("PhoneInventoryService-saveInventory, phoneInventory:{}", phoneInventory);
        return restFulApiClient.postPhoneInventoryDataToExternalApi(phoneInventory);
    }
}
