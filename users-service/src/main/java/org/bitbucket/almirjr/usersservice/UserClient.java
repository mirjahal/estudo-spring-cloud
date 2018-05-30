package org.bitbucket.almirjr.usersservice;

import feign.RequestLine;

public interface UserClient {

    @RequestLine("GET")
    User findUserById();

}
