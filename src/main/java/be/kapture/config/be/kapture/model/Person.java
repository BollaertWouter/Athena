package be.kapture.config.be.kapture.model;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(appliesTo = "persons")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private AdministrativeInfo administrativeInfo;
	@NotNull
	private PersonType type;


	public long getId() {
		return id;
	}

	public AdministrativeInfo getAdministrativeInfo() {
		return administrativeInfo;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(@NotNull PersonType type) {
		this.type = type;
	}
}
