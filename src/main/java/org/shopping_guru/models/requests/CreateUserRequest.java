package org.shopping_guru.models.requests;

import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.ProductOrig;
import org.shopping_guru.models.UserModel;

import java.util.List;
import java.util.Objects;

public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String ipAddress;

    public CreateUserRequest() {}

    public CreateUserRequest(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.ipAddress = builder.ipAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateUserRequest)) return false;
        CreateUserRequest that = (CreateUserRequest) o;
        return Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getIpAddress(), that.getIpAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPassword(), getIpAddress());
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String ipAddress;

        public Builder withFirstName(String firstNameToUse) {
            this.firstName = firstNameToUse;
            return this;
        }

        public Builder withLastName(String lastNameToUse) {
            this.lastName = lastNameToUse;
            return this;
        }

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public Builder withPassword(String passwordToUse) {
            this.password = passwordToUse;
            return this;
        }

        public Builder withIpAddress(String ipAddressTouse) {
            this.ipAddress = ipAddressTouse;
            return this;
        }

        public CreateUserRequest build() {return new CreateUserRequest(this);}
    }
}
