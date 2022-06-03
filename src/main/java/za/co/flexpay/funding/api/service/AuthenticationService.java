package za.co.flexpay.funding.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Service
public class AuthenticationService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);
    @Value("${access.bank.hvc-api.username}")
    private String username;
    @Value("${access.bank.hvc-api.password}")
    private String password;

    /**
     * Validate the request credentials
     *
     * @param username
     * @param password
     * @return boolean
     */
    public boolean validateRequest(String username, String password) {

        if (username == null || password == null) {
            return false;
        }
        try {
            if (username.equals(this.username) && password.equals(this.password))
                return true;
        } catch (Exception e) {
            LOG.error("Error validating request: ", e);
            return false;
        }
        return false;
    }


}
