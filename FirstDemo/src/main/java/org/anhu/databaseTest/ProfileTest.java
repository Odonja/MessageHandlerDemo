package org.anhu.databaseTest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProfileTest {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private int rfid;

	@Column(nullable = false)
	private String name;

	protected ProfileTest() {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly
	}

	public ProfileTest(int rfid, String name) {
		this.rfid = rfid;
		this.name = name;
	}

	public int getRfid() {
		return rfid;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("Profile[id=%d, rfid='%s', name='%s']", id, rfid, name);
	}

}
