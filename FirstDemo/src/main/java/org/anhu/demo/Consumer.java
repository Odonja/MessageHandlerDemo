package org.anhu.demo;

import java.util.ArrayList;
import java.util.List;

import org.anhu.demo.database.Profile;
import org.anhu.demo.database.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// which port to listen to is set in application.properties in the resources folder
@RestController
public class Consumer {

	List<Message> messages = new ArrayList<>();
	@Autowired
	ProfileRepository repository;

	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public List<Message> messageGet() {
		System.out.println("get message was sent");
		return messages;
	}

	@RequestMapping(value = "/abc", method = RequestMethod.POST)
	public List<String> messagePost(@RequestBody Message message) {
		System.out.println("Message received is: " + message.toString());
		messages.add(message);
		List<Profile> query = repository.findByRfid(message.getRfid());
		List<String> identities = new ArrayList<>();
		for (Profile p : query) {
			identities.add(p.getName());
		}
		return identities;
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
