package org.anhu.demo.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Repository<Profile, Long> de eerste is de classe die in de database is opgeslagen, de tweede de unieke identifier
public interface ProfileRepository extends CrudRepository<Profile, Long> {

	List<Profile> findByRfid(int rfid);

	List<Profile> findByName(String name);
}
