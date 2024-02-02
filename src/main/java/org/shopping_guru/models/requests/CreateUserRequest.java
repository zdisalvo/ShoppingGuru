package org.shopping_guru.models.requests;

import org.shopping_guru.dynamodb.models.ProductOrig;
import org.shopping_guru.models.UserModel;

import java.util.List;
import java.util.Objects;

public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> preferences;
    private List<ProductOrig> wishList;

    public CreateUserRequest() {}

    public CreateUserRequest(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.preferences = builder.preferences;
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

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    public List<ProductOrig> getWishList() {
        return wishList;
    }

    public void setWishList(List<ProductOrig> wishList) {
        this.wishList = wishList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(getFirstName(), userModel.getFirstName()) && Objects.equals(getLastName(), userModel.getLastName()) && Objects.equals(getEmail(), userModel.getEmail()) && Objects.equals(getPassword(), userModel.getPassword()) && Objects.equals(getPreferences(), userModel.getPreferences());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail(), getPassword(), getPreferences());
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", preferences=" + preferences +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private List<String> preferences;
        private List<ProductOrig> wishList;

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

        public Builder withPreferences(List<String> preferencesToUse) {
            this.preferences = preferencesToUse;
            return this;
        }

        public Builder withWishList(List<ProductOrig> wishListToUse) {
            this.wishList = wishListToUse;
            return this;
        }

        public CreateUserRequest build() {return new CreateUserRequest(this);}
    }
}
