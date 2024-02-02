package org.shopping_guru.lambda;

import com.amazonaws.Request;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.shopping_guru.activity.ScrapeProductsActivity;
import org.shopping_guru.dependency.DaggerServiceComponent;
import org.shopping_guru.dependency.ServiceComponent;
import org.shopping_guru.models.requests.ScrapeProductsRequest;
import org.shopping_guru.models.results.ScrapeProductsResult;

public class ScrapeProductsActivityProvider implements RequestHandler<ScrapeProductsRequest, ScrapeProductsResult> {

    public ScrapeProductsActivityProvider(){}

    @Override
    public ScrapeProductsResult handleRequest(final ScrapeProductsRequest scrapeProductsRequest, Context context) {
        return getDagger().handleRequest(scrapeProductsRequest, context);
    }

    private ScrapeProductsActivity getDagger(){
        ServiceComponent dagger = DaggerServiceComponent.create();
        ScrapeProductsActivity scrapeProductsActivity = dagger.provideScrapeProductsActivity();
        return scrapeProductsActivity;
    }
}
