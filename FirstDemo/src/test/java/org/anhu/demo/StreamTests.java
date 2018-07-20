package org.anhu.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class StreamTests {

	@Test
	public void test1() {
//		Maak een lijst met 200 Messages met Rfid random in reeks 0-20 & readerId in reeks 0-5.
//		maak een stream die telt hoveel messages er zij met 3<=rfid<=8 && readerid>2
		List<Message> list = createRandomMessages(200);
		int outcome = (int) list.stream().filter(s -> s.getRfid() >= 3 && s.getRfid() >= 8 && s.getReaderid() > 2)
				.count();
		int counter = 0;
		for (Message message : list) {
			if (message.getRfid() >= 3 && message.getRfid() >= 8 && message.getReaderid() > 2) {
				counter++;
			}
		}
		assertEquals(counter, outcome);
	}

	@Test
	public void test2() {
//	Maak een lijst met 200 Messages met Rfid random in reeks 0-20 & readerId in reeks 0-5.
//		maak een stream die alle oneven rfid optelt 
		List<Message> list = createRandomMessages(200);
		int outcome = list.stream().filter(s -> s.getRfid() % 2 == 1).mapToInt(s -> s.getRfid()).sum();
		int counter = 0;
		for (Message message : list) {
			if (message.getRfid() % 2 == 1) {
				counter += message.getRfid();
			}
		}
		assertEquals(counter, outcome);
	}

	@Test
	public void test3() {
//		 hetzelfde als (2) maar nu het gemiddelde betekent
		List<Message> list = createRandomMessages(200);
		double outcome = list.stream().filter(s -> s.getRfid() % 2 == 1).mapToInt(s -> s.getRfid()).summaryStatistics()
				.getAverage();
		double counter = 0;
		double sum = 0;
		for (Message message : list) {
			if (message.getRfid() % 2 == 1) {
				sum += message.getRfid();
				counter++;
			}
		}
		double value = sum / counter;
		assertEquals(value, outcome, 0.001);
	}

	private List<Message> createRandomMessages(int nrOfMessages) {
		Random random = new Random();
		List<Message> list = new ArrayList<>();
		for (int i = 0; i < nrOfMessages; i++) {
			list.add(new Message(random.nextInt(21), random.nextInt(6)));
		}
		return list;
	}

}
