package org.bitbucket.almirjr.usersservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://reqres.in/api/users", path = "data")
public interface UserClient {

    @GetMapping("/{id}")
    User findUserById(@PathVariable("id") int id);

}
