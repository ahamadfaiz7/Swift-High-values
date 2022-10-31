package za.co.flexpay.funding.api.wsclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import za.co.flexpay.funding.api.model.SwiftFundingResponse;
import za.co.flexpay.funding.api.model.SwiftInFundingRequest;

@Service
public class SwiftFundingServiceClient {

    private static final Logger LOG = LoggerFactory.getLogger(SwiftFundingServiceClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${flexpay.customer-api.service.url}")
    private String otpServiceUrl;
    @Value("${flexPay.funding.old.stack.api.username}")
    private String flexPayFundingUserName;
    @Value("${flexPay.funding.old.stack.api.password}")
    private String flexPayFundingPassword;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;


    /**
     * @param swiftInFundingRequest
     * @return
     */
    public SwiftFundingResponse swiftFundAccount(SwiftInFundingRequest swiftInFundingRequest) {

        SwiftFundingResponse swiftFundingResponse = null;
        restTemplate = restTemplateBuilder
                .basicAuthentication(flexPayFundingUserName, flexPayFundingPassword)
                .build();
        try {
            LOG.info("Making API call to-> "+ otpServiceUrl);
            swiftFundingResponse = restTemplate.postForObject(otpServiceUrl, swiftInFundingRequest, SwiftFundingResponse.class);
            LOG.info("API call to "+ otpServiceUrl+ " has recieved a response.");
            LOG.info("API response message-> "+swiftFundingResponse.getErrorDescription());
        }
        catch(HttpClientErrorException e) {
            if (e.getMessage().contains("Unauthorized")) {
                LOG.error(String.format("The credentials to call the Flexpay Funding API is incorrect", otpServiceUrl), e.getMessage());
            } else {
                LOG.error(String.format("Flexpay Funding API is unavailable", otpServiceUrl), e.getMessage());
            }
            swiftFundingResponse = new SwiftFundingResponse(swiftInFundingRequest.getUniqueEndToEndIdentifier(), "DS28", "Return for Technical Reason");
        }
        catch (Exception e) {
            swiftFundingResponse = new SwiftFundingResponse(swiftInFundingRequest.getUniqueEndToEndIdentifier(),"DS28","Return for Technical Reason");
            LOG.error(String.format("Error calling service[%s]", otpServiceUrl), e.getMessage());
        }
        return swiftFundingResponse;
    }
}
