package be.kapture.model;


import lombok.Builder;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@Builder
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

    protected ContactInfo() {
    }

    public static class ContactInfoBuilder {
        private ContactInfo info;

        public ContactInfoBuilder() {
            info = new ContactInfo();
        }

        public ContactInfo create() {
            return info;
        }

        public ContactInfo setTelNumber(String tel) {
            info.setTelNumber(tel);

            return info;
        }

        public ContactInfo setMobileNumber(String tel) {
            info.setMobileNumber(tel);

            return info;
        }

        public ContactInfo setFax(String fax) {
            info.setFax(fax);

            return info;
        }

        public ContactInfo setEmail(String email) {
            info.setEmail(email);

            return info;
        }

        public ContactInfo setAddress(Address address) {
            info.address = address;

            return info;
        }
    }

    public Address getAddress() {
        return address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(@NotBlank String telNumber) {
        String result = formatNumbers(telNumber);
        if (validateNumber(result)) {
            this.telNumber = result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotBlank String mobileNumber) {
        String result = formatNumbers(mobileNumber);
        if (validateNumber(result)) {
            this.mobileNumber = result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getFax() {
        return fax;
    }

    public void setFax(@NotBlank String fax) {
        String result = formatNumbers(fax);
        if (validateNumber(result)) {
            this.fax = result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    boolean validateEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    boolean validateNumber(String number) {
        return number.matches("[0-9]*");
    }

    String formatNumbers(String number) {
        return number.replaceAll(" ", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return address.equals(that.address) &&
                Objects.equals(telNumber, that.telNumber) &&
                mobileNumber.equals(that.mobileNumber) &&
                email.equals(that.email) &&
                Objects.equals(fax, that.fax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, telNumber, mobileNumber, email, fax);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactInfo{");
        sb.append("address=").append(address);
        sb.append(", telNumber='").append(telNumber).append('\'');
        sb.append(", mobileNumber='").append(mobileNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", fax='").append(fax).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
