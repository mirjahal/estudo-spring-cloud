package org.bitbucket.almirjr.usersservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "users", url = "${mocky.user-service-uri}")
public interface UserClient {

    @GetMapping
    User findUserById();

}
