package za.co.flexpay.funding.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.flexpay.funding.api.model.SwiftInFundingRequest;
import za.co.flexpay.funding.api.model.SwiftFundingResponse;
import za.co.flexpay.funding.api.constant.ApplicationConstants;
import za.co.flexpay.funding.api.wsclient.SwiftFundingServiceClient;

/**
 * @RestController annotation is used in order to simplify the creation of RESTful web services.<br/>
 * It's a convenient annotation that combines @Controller and @ResponseBody, <br/>
 * which eliminates the need to annotate every class with the @ResponseBody annotation.<br/>
 *
 */
@RestController
@RequestMapping(ApplicationConstants.BASE_PATH_V1)
public class SwiftFundingApi {


    private SwiftFundingServiceClient swiftFundingServiceClient;

    @Autowired
    public void setSwiftFundingServiceClient(SwiftFundingServiceClient swiftFundingServiceClient) {
        this.swiftFundingServiceClient = swiftFundingServiceClient;
    }

    /**
     * Jackson serializer will take care of converting to json
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/swift-funding")
    public SwiftFundingResponse processRemoteMessage(@RequestBody SwiftInFundingRequest request) {

        SwiftFundingResponse response = swiftFundingServiceClient.swiftFundAccount(request);

        return response;
    }
}
