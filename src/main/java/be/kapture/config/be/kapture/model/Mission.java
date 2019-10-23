package be.kapture.config.be.kapture.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "missions")
public class Mission {

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




}
