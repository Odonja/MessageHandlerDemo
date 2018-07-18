package org.anhu.demo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FirstDemoApplicationTests {
	
	private Thread thread;
	
//	@Before
//	public void startApplication() {
//		thread = new Thread(() ->  new FirstDemoApplication());
//		thread.start();	
//	}
//	@After
//	public void stopApplication() {
//		thread.interrupt();
//	}	

	@Test
	public void contextLoads() throws InterruptedException {
		
		// Thread.sleep(5000);

		final String uri = "http://localhost:8080/abc";

		Message message = new Message(1, 2);

		RestTemplate restTemplate = new RestTemplate();
		Message result = restTemplate.postForObject(uri, message, Message.class);

		System.out.println(result);
		assertEquals(message.getRfid(), result.getRfid());
		assertEquals(message.getReaderid(), result.getReaderid());
	}

}
