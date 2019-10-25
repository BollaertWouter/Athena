package be.kapture.model;

import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(appliesTo = "persons")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Embedded
	private AdministrativeInfo administrativeInfo;
	@NotNull
	private PersonType type;

	protected Person(){}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return id == person.id &&
				type == person.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Person{");
		sb.append("id=").append(id);
		sb.append(", administrativeInfo=").append(administrativeInfo.toString());
		sb.append(", type=").append(type);
		sb.append('}');
		return sb.toString();
	}
}
