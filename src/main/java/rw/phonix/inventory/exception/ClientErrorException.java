package rw.phonix.inventory.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.reactive.function.client.ClientResponse;

@Getter
@Setter
public class ClientErrorException extends RuntimeException{
    private final ClientResponse response;

    public ClientErrorException(String message, ClientResponse response) {
        super(message);
        this.response = response;
    }
}
