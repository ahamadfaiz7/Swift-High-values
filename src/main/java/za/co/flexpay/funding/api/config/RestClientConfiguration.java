package za.co.flexpay.funding.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import za.co.flexpay.funding.api.wsclient.RestTemplateResponseErrorHandler;

@Configuration
public class RestClientConfiguration {

    private RestTemplateBuilder restTemplateBuilder;

    public RestClientConfiguration(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder
            .errorHandler(new RestTemplateResponseErrorHandler())
            .build();
    }
}
