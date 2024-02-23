package org.shopping_guru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.shopping_guru.activity.DisplaySavedActivity;
import org.shopping_guru.activity.SaveProductsActivity;
import org.shopping_guru.dependency.DaggerServiceComponent;
import org.shopping_guru.dependency.ServiceComponent;
import org.shopping_guru.models.requests.DisplaySavedRequest;
import org.shopping_guru.models.requests.SaveProductsRequest;

public class DisplaySavedActivityProvider implements RequestHandler<DisplaySavedRequest, String> {

    public DisplaySavedActivityProvider(){}


    @Override
    public String handleRequest(final DisplaySavedRequest displaySavedRequest, Context context) {
        return getDagger().handleRequest(displaySavedRequest, context);
    }

    private DisplaySavedActivity getDagger(){
        ServiceComponent dagger = DaggerServiceComponent.create();
        DisplaySavedActivity displaySavedActivity = dagger.provideDisplaySavedActivity();
        return displaySavedActivity;
    }
}
