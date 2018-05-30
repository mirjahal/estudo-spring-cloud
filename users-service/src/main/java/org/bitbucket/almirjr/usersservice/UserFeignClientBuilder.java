package org.bitbucket.almirjr.usersservice;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class UserFeignClientBuilder {

    @Value("${mocky.user-service-uri}")
    private String userServiceUri;

    private UserClient userClient = createClient(UserClient.class, userServiceUri);

    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(type, uri);
    }

    public UserClient getUserClient() {
        return userClient;
    }

}
