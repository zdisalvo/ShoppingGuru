package org.shopping_guru.serpapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class GoogleShoppingSearch {

    public void shoppingSearch() {

        Map<String, String> parameter = new HashMap<>();

        parameter.put("engine", "google_shopping");
        parameter.put("q", "Coffee");
        parameter.put("location", "Austin, Texas, United States");
        parameter.put("hl", "en");
        parameter.put("gl", "us");
        parameter.put("api_key", "secret_api_key");

        GoogleSearch search = new GoogleSearch(parameter);

        JsonObject results = null;
        try {
            results = search.getJson();
        } catch (SerpApiSearchException e) {
            throw new RuntimeException(e);
        }
        JsonElement shopping_results = results.get("shopping_results");
        System.out.println(shopping_results.getAsJsonArray());
    }

}
