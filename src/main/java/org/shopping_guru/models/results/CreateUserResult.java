package org.shopping_guru.models.results;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.shopping_guru.models.UserModel;

public class CreateUserResult extends APIGatewayProxyResponseEvent{

    private UserModel user;


    public CreateUserResult(Builder builder) {this.user = builder.user; }


    public UserModel getUser() {return user;}

    public void setUser(UserModel user) {this.user = user;}

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private UserModel user;

        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }

        public CreateUserResult build() {return new CreateUserResult(this);}
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
