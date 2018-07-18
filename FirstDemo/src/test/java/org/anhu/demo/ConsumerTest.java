package org.anhu.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ConsumerTest {

	private static final int READERID = 1;
	private static final int RFID = 2;
	private static final Message MESSAGE = new Message(RFID, READERID);

	@Test
	public void test() {
		Consumer consumer = new Consumer();
		
		List<Message> message0 = consumer.messageGet();		
		assertEquals(0, message0.size());
		
		consumer.messagePost(MESSAGE);
		List<Message> message1 = consumer.messageGet();		
		assertEquals(1, message1.size());		
		
	}

}
