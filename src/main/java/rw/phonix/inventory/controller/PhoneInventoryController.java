package rw.phonix.inventory.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import rw.phonix.inventory.Model.PhoneInventory;
import rw.phonix.inventory.service.PhoneInventoryService;

@RestController
@RequestMapping("/api/inventory/phone")
public class PhoneInventoryController {

    private final PhoneInventoryService phoneInventoryService;

    public PhoneInventoryController(PhoneInventoryService phoneInventoryService) {
        this.phoneInventoryService = phoneInventoryService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PhoneInventory> saveInventory(@RequestBody PhoneInventory phoneInventory) {
        return phoneInventoryService.saveInventory(phoneInventory);
    }
}
