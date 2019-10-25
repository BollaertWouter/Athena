package be.kapture.model;

import lombok.Builder;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Builder
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

    protected AdministrativeInfo(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( @NotBlank(message = "name can't be empty") String firstName) {
        if(isValid(firstName)) {
            this.firstName = firstName;
        }else {throw new IllegalArgumentException();}
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "name can't be empty") String lastName) {
        if(isValid(lastName)) {
            this.lastName = lastName;
        }else {throw new IllegalArgumentException();}
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrativeInfo that = (AdministrativeInfo) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                dateOfBirth.equals(that.dateOfBirth) &&
                sex == that.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, sex);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdministrativeInfo{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", sex=").append(sex);

        sb.append(", contactInfo=").append(contactInfo.toString());
        sb.append('}');
        return sb.toString();
    }
}
