package org.bitbucket.almirjr.usersservice;

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

    @Autowired
    private UserClient userClient;

    @GetMapping("server-port")
    public String getServerPort() {
        return serverPort;
    }

    @GetMapping("user")
    public User getUser() {
        return userClient.findUserById(2);
    }

}
