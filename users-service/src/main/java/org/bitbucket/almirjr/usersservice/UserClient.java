package org.bitbucket.almirjr.usersservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "users", url = "http://www.mocky.io/v2/5b05e1d93200009213ebfa7e")
public interface UserClient {

    @GetMapping
    User findUserById(int id);

}
