package org.shopping_guru.activity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.shopping_guru.dynamodb.ProductDao;
import org.shopping_guru.models.requests.ScrapeProductsRequest;
import org.shopping_guru.models.requests.ScrapeProductsRequestOrig;

import static org.mockito.MockitoAnnotations.initMocks;

public class ScrapeProductsTest {

    @Mock
    ProductDao productDao;

    private ScrapeProductsActivity scrapeProductsActivity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        scrapeProductsActivity = new ScrapeProductsActivity(productDao);

    }

    @Test
    public void handleRequest_PageIsScraped_andPrinted() {

        ScrapeProductsRequest scrapeProductsRequest = new ScrapeProductsRequest();
        scrapeProductsRequest.setPrice(40.0);
        scrapeProductsRequest.setResultsNum(20);
        scrapeProductsRequest.setSearchPhrase("large bath towels");



        scrapeProductsActivity.handleRequest(scrapeProductsRequest, null);


    }





}
