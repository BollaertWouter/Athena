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

    public void setTelNumber(@NotBlank String telNumber) {
        String result = formatNumbers(telNumber);
        if(validateNumber(result)){
            this.telNumber=result;
        } else {throw new IllegalArgumentException();}
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotBlank String mobileNumber) {
        String result = formatNumbers(mobileNumber);
        if(validateNumber(result)){
            this.mobileNumber=result;
        } else {throw new IllegalArgumentException();}
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank  String email) {
        if(validateEmail(email)){
            this.email = email;
        }else {throw new IllegalArgumentException();}
    }

    public String getFax() {
        return fax;
    }

    public void setFax(@NotBlank String fax) {
        String result = formatNumbers(fax);
        if(validateNumber(result)){
            this.fax=result;
        } else {throw new IllegalArgumentException();}
    }

    boolean validateEmail (String email){
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    boolean validateNumber(String number){
        return number.matches("[0-9]*");
    }

    String formatNumbers(String number){
        return number.replaceAll(" ","");
    }

}
