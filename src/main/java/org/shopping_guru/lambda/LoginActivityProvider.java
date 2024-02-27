package org.shopping_guru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.shopping_guru.activity.CreateUserActivity;
import org.shopping_guru.activity.LoginActivity;
import org.shopping_guru.dependency.DaggerServiceComponent;
import org.shopping_guru.dependency.ServiceComponent;
import org.shopping_guru.models.requests.CreateUserRequest;
import org.shopping_guru.models.requests.LoginRequest;

public class LoginActivityProvider implements RequestHandler<LoginRequest, String> {

    public LoginActivityProvider() {}

    @Override
    public String handleRequest(final LoginRequest loginRequest, Context context) {
        return getDagger().handleRequest(loginRequest, context);
    }

    private LoginActivity getDagger(){
        ServiceComponent dagger = DaggerServiceComponent.create();
        LoginActivity loginActivity = dagger.provideLoginActivity();
        return loginActivity;
    }
}
