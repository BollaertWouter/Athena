package be.kapture.config.be.kapture.model;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(appliesTo = "persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long administrativeInfoId;
	private PersonType type;

	public Person(long administrativeInfoId, PersonType type) {
		this.administrativeInfoId = administrativeInfoId;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAdministrativeInfoId() {
		return administrativeInfoId;
	}

	public void setAdministrativeInfoId(long administrativeInfoId) {
		this.administrativeInfoId = administrativeInfoId;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}
}
