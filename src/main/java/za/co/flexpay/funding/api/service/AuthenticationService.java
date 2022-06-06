package za.co.flexpay.funding.api.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Service
public class AuthenticationService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);
    @Value("${flexpay.funding.hvc-api.username}")
    private String username;
    @Value("${flexpay.funding.hvc-api.password}")
    private String password;

    /**
     * Validate the request credentials<br/>
     * Convert the HTTP basic Auth authorization param using decodeBase64<br/>
     * fetch the credentials from authorization after decoding<br/>
     *
     * @param authorizationData
     * @return boolean
     */
    public boolean validateRequest(String authorizationData) {
        String key;
        String value;
        if (authorizationData == null || password == null) {
            return false;
        }
        try {
            authorizationData = authorizationData.replaceAll(" ", "");
            authorizationData = authorizationData.replaceAll("Basic", "");
            byte[] valueDecoded = Base64.decodeBase64(authorizationData);
            String credentials = new String(valueDecoded);
            if (credentials.contains(":")) {
                String[] credentialsArray = credentials.split(":");
                key = credentialsArray[0];
                value = credentialsArray[1];
            } else {
                return false;
            }
            if (key.equals(this.username) && value.equals(this.password))
                return true;
        } catch (Exception e) {
            LOG.error("Error validating request: ", e);
            return false;
        }
        return false;
    }


}
