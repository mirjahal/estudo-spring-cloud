package org.bitbucket.almirjr.usersservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("server-port")
    public String getServerPort() {
        return serverPort;
    }

}
