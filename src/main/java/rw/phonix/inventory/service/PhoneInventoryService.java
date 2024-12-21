package rw.phonix.inventory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import rw.phonix.inventory.Model.PhoneInventory;

@Service
@Slf4j
public class PhoneInventoryService {

    public Mono<Boolean> saveInventory(String id, PhoneInventory phoneInventory) {
        log.info("saveInventory, id:{} phoneInventory:{}", id, phoneInventory);
        return Mono.just(Boolean.TRUE);
    }
}
