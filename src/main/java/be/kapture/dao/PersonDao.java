package be.kapture.dao;

import be.kapture.model.Person;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Entity
@Table(appliesTo = "persons")
public class PersonDao extends AbstractDao<Person> {
	@Override
	public Optional<Person> get(long id) {
		return Optional.empty();
	}

	@Override
	public List<Person> getAll() {
		return null;
	}
}
