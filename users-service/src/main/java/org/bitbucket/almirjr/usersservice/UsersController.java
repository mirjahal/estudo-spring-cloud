package org.bitbucket.almirjr.usersservice;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UsersController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${mocky.user-service-uri}")
    private String userServiceUri;

    @GetMapping("server-port")
    public String getServerPort() {
        return serverPort;
    }

    @GetMapping("user")
    public User getUser() {
        return FeignClientBuilder.build(UserClient.class, userServiceUri).findUserById();
    }

    @GetMapping("uri")
    public String getUserServiceUri() {
        return userServiceUri;
    }

}
