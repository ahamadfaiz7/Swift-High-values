package za.co.flexpay.funding.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 500 HTTP ERROR code to be returned if authorization fails
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class GenericException extends Exception {
    public GenericException(String msg) {
        super(msg);
    }
}
