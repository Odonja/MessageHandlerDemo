package org.anhu.databaseTest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Repository<Profile, Long> de eerste is de classe die in de database is opgeslagen, de tweede de unieke identifier
public interface ProfileRepositoryTest extends CrudRepository<ProfileTest, Long> {

	List<ProfileTest> findByRfid(int rfid);

	List<ProfileTest> findByName(String name);
}
