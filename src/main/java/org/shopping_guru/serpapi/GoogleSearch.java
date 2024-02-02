package org.shopping_guru.serpapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

/***
 * Google Search Results using SerpApi
 *
 * Usage 
 * --- 
 * <pre>
 * {@code 
 * Map<String, String> parameter = new HashMap<>();
 * parameter.put("q", "Coffee");
 * GoogleSearch google = new GoogleSearch(parameter, "secret api key"); 
 * JsonObject data = google.getJson();
 * JsonArray organic_results = data.get("organic_results").getAsJsonArray();
 * }
 * </pre>
 */
public class GoogleSearch extends SerpApiSearch {

 /**
  * Constructor
  * @param parameter search parameter
  * @param apiKey secret API key
  */
  public GoogleSearch(Map<String, String> parameter, String apiKey) {
    super(parameter, apiKey, "google");
  }

 /**
  * Constructor
  */
  public GoogleSearch() {
    super("google");
  }

 /**
  * Constructor
  * @param parameter search parameter
  */
  public GoogleSearch(Map<String, String> parameter) {
    super(parameter, "google");
  }

    public JsonElement shoppingSearch() {

        Map<String, String> parameter = new HashMap<>();

        parameter.put("engine", "google_shopping");
        parameter.put("q", "Coffee");
        parameter.put("location", "Austin, Texas, United States");
        parameter.put("hl", "en");
        parameter.put("gl", "us");
        //parameter.put("api_key", "secret_api_key");

        GoogleSearch search = new GoogleSearch(parameter);

        JsonObject results = null;
        try {
            results = search.getJson();
        } catch (SerpApiSearchException e) {
            throw new RuntimeException(e);
        }
        JsonElement shopping_results = results.get("shopping_results");
        System.out.println(shopping_results.getAsJsonArray());

        return shopping_results;
    }

// end
}