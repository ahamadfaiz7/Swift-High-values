package za.co.flexpay.funding.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import za.co.flexpay.funding.api.exceptions.GenericException;
import za.co.flexpay.funding.api.exceptions.UnauthorisedException;
import za.co.flexpay.funding.api.model.SwiftInFundingRequest;
import za.co.flexpay.funding.api.model.SwiftFundingResponse;
import za.co.flexpay.funding.api.constant.ApplicationConstants;
import za.co.flexpay.funding.api.service.AuthenticationService;
import za.co.flexpay.funding.api.wsclient.SwiftFundingServiceClient;

/**
 * @RestController annotation is used in order to simplify the creation of RESTful web services.<br/>
 * It's a convenient annotation that combines @Controller and @ResponseBody, <br/>
 * which eliminates the need to annotate every class with the @ResponseBody annotation.<br/>
 */
@RestController
@RequestMapping(ApplicationConstants.BASE_PATH_V1)
public class SwiftFundingApi {

    private static final Logger LOG = LoggerFactory.getLogger(SwiftFundingApi.class);
    private SwiftFundingServiceClient swiftFundingServiceClient;
    private AuthenticationService authenticationService;
    private String responseStatus;

    @Autowired
    public void setSwiftFundingServiceClient(SwiftFundingServiceClient swiftFundingServiceClient) {
        this.swiftFundingServiceClient = swiftFundingServiceClient;
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Jackson serializer will take care of converting to json
     *
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/swift-funding")
    public SwiftFundingResponse processRemoteMessage(@RequestHeader MultiValueMap<String, String> headers, @RequestBody SwiftInFundingRequest request) throws UnauthorisedException, GenericException {
        try {
            String authorizationData = String.valueOf(headers.get("authorization")).replaceAll("[\\[\\]]", "");
            if (!authenticationService.validateRequest(authorizationData)) {
                throw new UnauthorisedException("Unauthorized");
            }
            SwiftFundingResponse response = swiftFundingServiceClient.swiftFundAccount(request);
            return response;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            if (e instanceof UnauthorisedException) {
                LOG.error("Authorization of incoming request failed.");
                throw new UnauthorisedException("Unauthorized");
            } else {
                throw new GenericException("Exception");
            }
        }
    }
}
