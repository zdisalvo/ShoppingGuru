package org.shopping_guru.models.requests;

import java.util.Objects;

public class LoginRequest {

    private String email;
    private String password;

    public LoginRequest() {}

    public LoginRequest(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginRequest)) return false;
        LoginRequest that = (LoginRequest) o;
        return Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword());
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();};

    public static final class Builder {
        private String email;
        private String password;

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() { return new LoginRequest(this);}
    }
}
