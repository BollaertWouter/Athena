package be.kapture.model;

import lombok.Builder;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Embeddable
@Builder
class Address {
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    private String box;
    @NotBlank
    private String city;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;

    protected Address(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(@NotBlank String street) {
        if(isValid(street)){
            this.street = street;
        } else {throw new IllegalArgumentException();}
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(@NotBlank String number) {
        if(isValid(number)){
            this.number = number;
        } else {throw new IllegalArgumentException();}
    }

    public String getBox() {
        return box;
    }

    public void setBox(@NotBlank String box) {
        if(isValid(box)){
            this.box = box;
        } else {throw new IllegalArgumentException();}
    }

    public String getCity() {
        return city;
    }

    public void setCity(@NotBlank String city) {
        if(isValid(city)){
            this.city = city;
        } else {throw new IllegalArgumentException();}
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@NotBlank String postalCode) {
        if(isValid(postalCode)){
            this.postalCode = postalCode;
        } else {throw new IllegalArgumentException();}
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(@NotBlank String country) {
        if(isValid(country)){
            this.country = country;
        } else {throw new IllegalArgumentException();}
    }

    private boolean isValid(String input){
        String regex = "([aA-zZ0-9])*";
        return input.matches(regex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return street.equals(address.street) &&
                number.equals(address.number) &&
                box.equals(address.box) &&
                city.equals(address.city) &&
                postalCode.equals(address.postalCode) &&
                country.equals(address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, box, city, postalCode, country);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("street='").append(street).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append(", box='").append(box).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", postalCode='").append(postalCode).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
