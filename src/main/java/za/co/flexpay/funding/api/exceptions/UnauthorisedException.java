package za.co.flexpay.funding.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 401 HTTP ERROR code to be returned if authorization fails
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorisedException extends Exception {
    public UnauthorisedException(String msg) {
        super(msg);
    }
}
