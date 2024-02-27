package org.shopping_guru.models.results;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Objects;

public class LoginResult extends APIGatewayProxyResponseEvent {

    String status;

    public LoginResult() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginResult)) return false;
        if (!super.equals(o)) return false;
        LoginResult that = (LoginResult) o;
        return Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStatus());
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "status='" + status + '\'' +
                '}';
    }

    public void setStatusCode(int statusCode, String body) {
        // Check if the status code is 400 and set a custom response if it is
        if (statusCode == 400) {
            setBody(body);
        }
        // Call the parent class method to set the status code
        super.setStatusCode(statusCode);
    }
}
