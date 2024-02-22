package org.shopping_guru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.shopping_guru.activity.SaveProductsActivity;
import org.shopping_guru.activity.ScrapeProductsActivity;
import org.shopping_guru.dependency.DaggerServiceComponent;
import org.shopping_guru.dependency.ServiceComponent;
import org.shopping_guru.models.requests.SaveProductsRequest;
import org.shopping_guru.models.requests.ScrapeProductsRequest;

public class SaveProductsActivityProvider implements RequestHandler<SaveProductsRequest, String> {

    public SaveProductsActivityProvider(){}

    @Override
    public String handleRequest(final SaveProductsRequest saveProductsRequest, Context context) {
        return getDagger().handleRequest(saveProductsRequest, context);
    }

    private SaveProductsActivity getDagger(){
        ServiceComponent dagger = DaggerServiceComponent.create();
        SaveProductsActivity saveProductsActivity = dagger.provideSaveProductsActivity();
        return saveProductsActivity;
    }
}
