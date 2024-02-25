package org.shopping_guru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.shopping_guru.activity.CreateUserActivity;
import org.shopping_guru.activity.DisplaySavedActivity;
import org.shopping_guru.dependency.DaggerServiceComponent;
import org.shopping_guru.dependency.ServiceComponent;
import org.shopping_guru.models.requests.CreateUserRequest;
import org.shopping_guru.models.requests.DisplaySavedRequest;
import org.shopping_guru.models.results.CreateUserResult;

public class CreateUserActivityProvider implements RequestHandler<CreateUserRequest, CreateUserResult> {

    public CreateUserActivityProvider() {}

    @Override
    public CreateUserResult handleRequest(final CreateUserRequest createUserRequest, Context context) {
        return getDagger().handleRequest(createUserRequest, context);
    }

    private CreateUserActivity getDagger(){
        ServiceComponent dagger = DaggerServiceComponent.create();
        CreateUserActivity createUserActivity = dagger.provideCreateUserActivity();
        return createUserActivity;
    }

}
