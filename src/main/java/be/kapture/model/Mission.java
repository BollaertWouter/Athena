package be.kapture.model;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.util.Collections;
import java.util.Set;

@Builder
@Entity
@Table(name = "missions")
public class Mission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Duration duration;
    private boolean isBillable;
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany
    @JoinTable(name = "missions_persons",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name="person_id"))
    private Set<Person> developers;
    @Version
    private int version;

    public long getId() {
        return id;
    }

    public Duration getDuration() {
        return duration;
    }

    public boolean isBillable() {
        return isBillable;
    }

    public Client getClient() {
        return client;
    }


    public Set<Person> getDevelopers() {
        return Collections.unmodifiableSet(developers);
    }

}
