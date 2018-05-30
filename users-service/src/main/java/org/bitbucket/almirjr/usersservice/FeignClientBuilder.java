package org.bitbucket.almirjr.usersservice;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class FeignClientBuilder {

    private FeignClientBuilder() {

    }

    public static <T> T build(Class<T> type, String uri) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(type, uri);
    }

}
