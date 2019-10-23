package be.kapture.model;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
class ContactInfo {
    @NotNull
    @Embedded
    private Address address;
    private String telNumber;
    @NotBlank
    private String mobileNumber;
    @NotBlank
    private String email;
    private String fax;

    public Address getAddress() {
        return address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public boolean validateEmail(String email){
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean validateNumber(String number){
        return number.matches("[0-9]*");
    }

    public String formatNumbers(String number){
        return number.replaceAll(" ","");
    }

}
