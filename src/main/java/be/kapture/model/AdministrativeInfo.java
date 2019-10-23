package be.kapture.model;

import javax.persistence.Embedded;
import javax.validation.constraints.*;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class AdministrativeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private LocalDate dateOfBirth;
    @NotNull
    private Sex sex;
    @NotNull
    @Embedded
    private ContactInfo contactInfo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( @NotBlank(message = "name can't be empty") String firstName) {
        if(isValid(firstName)) {
            this.firstName = firstName;
        }else throw new IllegalArgumentException();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "name can't be empty") String lastName) {
        if(isValid(lastName)) {
            this.lastName = lastName;
        }else throw new IllegalArgumentException();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull LocalDate dateOfBirth) {
        if(LocalDate.now().compareTo(dateOfBirth)<=0){
            throw new IllegalArgumentException();
        }else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex( @NotNull Sex sex) {
        this.sex = sex;
    }

    private boolean isValid(String input){
        String regex = "([aA-zZ0-9])*";
        return input.matches(regex);
    }
}
