package org.anhu.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstDemoApplicationTests {

	@Test
	public void contextLoads() {
		FirstDemoApplication demo = new FirstDemoApplication();

		final String uri = "http://localhost:8080/abc";

		Message message = new Message(1, 2);

		RestTemplate restTemplate = new RestTemplate();
		Message result = restTemplate.postForObject(uri, message, Message.class);

		System.out.println(result);
	}

}
