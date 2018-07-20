package org.anhu.demo;

import java.util.List;

import org.anhu.demo.database.Profile;
import org.anhu.demo.database.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

@RestController
public class AddDataPage {

	@Autowired
	ProfileRepository repository;

	@RequestMapping(value = "/addData", method = RequestMethod.GET)
	public List<Profile> showAddDataPage() {
		System.out.println("!!");
		return Lists.newArrayList(repository.findAll());
	}

	@RequestMapping(value = "/addData", method = RequestMethod.POST)
	public Profile addData(@RequestBody Profile profile) {
		repository.save(profile);
		return profile;
	}

	@RequestMapping("/save")
	public String process() {
		repository.save(new Profile(10, "Smith"));
		repository.save(new Profile(11, "Johnson"));
		repository.save(new Profile(12, "Smith"));
		repository.save(new Profile(13, "Williams"));
		repository.save(new Profile(14, "Davis"));
		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";

		for (Profile p : repository.findAll()) {
			result += p.toString() + "</br>";
		}

		return result;
	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id) {
		String result = "";
		result = repository.findById(id).toString();
		return result;
	}

	@RequestMapping("/findbyRfid")
	public String fetchDataByLastName(@RequestParam("rfid") int rfid) {
		String result = "";

		for (Profile p : repository.findByRfid(rfid)) {
			result += p.toString() + "</br>";
		}
		return result;
	}

}
