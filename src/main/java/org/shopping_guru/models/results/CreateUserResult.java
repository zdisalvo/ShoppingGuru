package org.shopping_guru.models.results;

import org.shopping_guru.models.UserModel;

public class CreateUserResult {

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

}
