package be.kapture.model;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "clients")
class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private List<Mission> missions;
    @Embedded
    private ContactInfo contactInfo;
    @NotBlank
    private String name;

    protected Client() {
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Client{").append("id=").append(id).append(", missions=");
        missions.forEach(output::append);
        output.append(", contactInfo=").append(contactInfo).append(", name='").append(name).append('\'').append('}');
        return output.toString();
    }
}
