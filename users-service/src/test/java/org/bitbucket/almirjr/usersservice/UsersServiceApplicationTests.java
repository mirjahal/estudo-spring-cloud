package org.bitbucket.almirjr.usersservice;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersServiceApplicationTests {

	@LocalServerPort
	private int port;

	@ClassRule
	public static WireMockClassRule wiremock = new WireMockClassRule(WireMockSpring.options().dynamicPort());

	@Autowired
	private UserClient userClient;

	@Test
	public void contextLoads() {
		wiremock.stubFor(get(urlEqualTo("/v2/5b05e1d93200009213ebfa7e"))
				.willReturn(aResponse()
				.withHeader("Content-Type", "application/json")
				.withBody(getJson())));

		assertEquals("Fiu", userClient.findUserById().getFirstName());
	}

	private String getJson() {
		return "{\"data\":{\"id\":2,\"first_name\":\"Fiu\",\"last_name\":\"Weaver\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"}}";
	}

}
