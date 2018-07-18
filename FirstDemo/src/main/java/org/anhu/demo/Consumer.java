package org.anhu.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// which port to listen to is set in application.properties in the resources folder
@RestController
public class Consumer {

	List<Message> messages = new ArrayList<>();

	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public List<Message> messageGet() {
		System.out.println("get message was sent");
		return messages;

	}

	@RequestMapping(value = "/abc", method = RequestMethod.POST)
	public void messagePost(@RequestBody Message message) {
		System.out.println("Message received is: " + message.toString());
		messages.add(message);
	}

	@RequestMapping(value = "/abc", method = RequestMethod.DELETE)
	public List<Message> messageDelete(@RequestBody Message message) {
		System.out.println("Message to be deleted is is: " + message.toString());
		for (Message m : messages) {
			if (m.getReaderid() == message.getReaderid() && m.getRfid() == message.getRfid()) {
				messages.remove(m);
				break;
			}
		}
		return messages;
	}
}
