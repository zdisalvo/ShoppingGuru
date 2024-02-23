package org.shopping_guru.models.requests;

import java.util.Objects;

public class DisplaySavedRequest {
    private String emailOrIp;

    public DisplaySavedRequest(){}

    public DisplaySavedRequest(Builder builder) {
        emailOrIp = builder.emailOrIp;
    }

    public String getEmailOrIp() {
        return emailOrIp;
    }

    public void setEmailOrIp(String emailOrIp) {
        this.emailOrIp = emailOrIp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisplaySavedRequest)) return false;
        DisplaySavedRequest that = (DisplaySavedRequest) o;
        return Objects.equals(emailOrIp, that.emailOrIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailOrIp);
    }

    @Override
    public String toString() {
        return "DisplaySavedRequest{" +
                "emailOrIp='" + emailOrIp + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String emailOrIp;

        Builder withEmailOrIp(String emailOrIpToUse) {
            this.emailOrIp = emailOrIpToUse;
            return this;
        }

        public DisplaySavedRequest build() {return new DisplaySavedRequest(this);}
    }
}
