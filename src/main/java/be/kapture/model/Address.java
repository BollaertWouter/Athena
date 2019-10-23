package be.kapture.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
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

    public String getStreet() {
        return street;
    }

    public void setStreet(@NotBlank String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(@NotBlank String number) {
        this.number = number;
    }

    public String getBox() {
        return box;
    }

    public void setBox(@NotBlank String box) {
        this.box = box;
    }

    public String getCity() {
        return city;
    }

    public void setCity(@NotBlank String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@NotBlank String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(@NotBlank String country) {
        this.country = country;
    }
}
