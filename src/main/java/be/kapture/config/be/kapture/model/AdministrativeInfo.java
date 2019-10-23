package be.kapture.config.be.kapture.model;

import javax.validation.constraints.*;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class AdministrativeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private LocalDate datOfBirth;
    @NotNull
    private Sex sex;
    @NotNull
    private ContactInfo contactInfo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( @NotBlank(message = "name can't be empty") String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "name can't be empty") String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDatOfBirth() {
        return datOfBirth;
    }

    public void setDatOfBirth(@NotNull LocalDate datOfBirth) {
        this.datOfBirth = datOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex( @NotNull Sex sex) {
        this.sex = sex;
    }
}
