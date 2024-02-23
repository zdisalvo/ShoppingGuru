package org.shopping_guru.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.shopping_guru.converters.ProductConverter;
import org.shopping_guru.dynamodb.ProductCachingDao;
import org.shopping_guru.dynamodb.ProductDao;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.ProductOrig;
import org.shopping_guru.dynamodb.models.ProductReview;
import org.shopping_guru.models.requests.ScrapeProductsRequest;
import org.shopping_guru.models.requests.ScrapeProductsRequestOrig;
import org.shopping_guru.models.results.ScrapeProductsResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;
import org.shopping_guru.serpapi.GoogleSearch;
import org.shopping_guru.serpapi.SerpApiSearchException;


import java.util.List;


public class ScrapeProductsActivity implements RequestHandler<ScrapeProductsRequest, String> {

    private final Logger log = LogManager.getLogger();
    private final ProductDao productDao;
    private final ProductCachingDao cachingDao;

    @Inject
    public ScrapeProductsActivity(ProductDao productDao, ProductCachingDao cachingDao) {

        this.productDao = productDao;
        this.cachingDao = cachingDao;
    }

    @Override
    public String handleRequest(ScrapeProductsRequest scrapeProductsRequest, Context context) {

        log.info("Received ScrapeProductsRequest {}", scrapeProductsRequest);

        //ProductOrig product = new ProductOrig();

        //ProductReview review = new ProductReview();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("engine", "google_shopping");
        parameter.put("q", scrapeProductsRequest.getSearchPhrase());
        //TODO Location
        parameter.put("location", "United States");
        parameter.put("hl", "en");
        parameter.put("gl", "us");
        //parameter.put("google_domain", "google.com");
        //parameter.put("engine", "google_shopping");
        parameter.put("api_key", GoogleSearch.getApiKey());
        //parameter.put("safe", "active");
        //parameter.put("start", "1");
        parameter.put("num", String.valueOf(Math.min(scrapeProductsRequest.getResultsNum() * 5, 100)));
        //parameter.put("device", "desktop");

        GoogleSearch googleSearch = new GoogleSearch(parameter);

        JsonElement results = googleSearch.shoppingSearch();

//        JsonObject results = null;
//        try {
//            results = search.getJson();
//        } catch (SerpApiSearchException e) {
//            throw new RuntimeException(e);
//        }
        //System.out.println(results.getAsJsonArray("shopping_results"));

        List<Product> products = new ArrayList<>();

        //JsonElement shopping_results = results.get("shopping_results");

        System.out.println(results.getAsJsonArray());

        for (JsonElement item : results.getAsJsonArray() ) {
            Product prod = ProductConverter.toProduct(item.toString());
            if (Double.parseDouble(prod.getPrice().substring(1)) <= scrapeProductsRequest.getPrice()
                    && products.size() <= scrapeProductsRequest.getResultsNum())
                    products.add(prod);
        }

        for (int i = 0 ; i < Math.min(products.size(), scrapeProductsRequest.getResultsNum()) ; i++) {
            Product prod = products.get(i);
            productDao.saveProduct(prod);
            cachingDao.getProductById(prod.getProductId());
            System.out.println(prod);
        }

//        return ScrapeProductsResult.builder()
//                .withProduct(products)
//                .build();

        return ProductConverter.toJson(products);
    }

}