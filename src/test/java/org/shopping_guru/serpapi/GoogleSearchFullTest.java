package org.shopping_guru.serpapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.shopping_guru.converters.ProductConverter;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.ProductOrig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Test main class
 */
public class GoogleSearchFullTest {

  GoogleSearch search;

  @Before
  public void setUp() throws Exception {
    if (System.getenv("API_KEY") != null) {
      GoogleSearch.api_key_default = System.getenv("API_KEY");
    }
  }

  @Test
  public void buildParameter() throws SerpApiSearchException {
    Map<String, String> parameter = new HashMap<>();
    parameter.put("q", "Coffee");
    parameter.put("location", "Austin, Texas");
    search = new GoogleSearch(parameter);
    search.buildQuery("/search", "html");
    assertEquals(search.parameter.get("source"), "java");
    assertEquals(search.parameter.get(GoogleSearch.API_KEY_NAME), GoogleSearch.api_key_default);
  }

  @Test
  public void builParameterForInstance() throws SerpApiSearchException {
    GoogleSearch search = new GoogleSearch();
    search.buildQuery("/search", "json");
    assertEquals(search.parameter.get("source"), "java");
    assertEquals(search.parameter.get("output"), "json");
    assertEquals(search.parameter.get(GoogleSearch.API_KEY_NAME), GoogleSearch.api_key_default);
  }

  @Test
  public void getApiKey() throws Exception {
    GoogleSearch.api_key_default = "abc";
    assertEquals("abc", GoogleSearch.getApiKey());
  }

  @Test
  public void asJson() throws Exception {
    GoogleSearch search = new GoogleSearch();
    JsonObject expectation = new JsonObject();
    expectation.add("status", new JsonPrimitive("ok"));
    assertEquals(expectation, search.asJson("{\"status\": \"ok\"}"));
  }

//  @Test
//  public void getHtml() throws Exception {
//    SerpApiHttpClient search = mock(SerpApiHttpClient.class);
//
//    String htmlContent = ReadJsonFile.readAsString(Paths.get("src/test/java/serpapi/data/search_coffee_sample.html"));
//    when(search.getResults(ArgumentMatchers.<String, String>anyMap())).thenReturn(htmlContent);
//
//    Map<String, String> parameter = new HashMap<>();
//    parameter.put("q", "Coffee");
//    parameter.put("location", "Austin, Texas");
//    GoogleSearch result = new GoogleSearch(parameter);
//    result.search = search;
//
//    assertEquals(htmlContent, result.getHtml());
//  }

//  @Test
//  public void getJson() throws Exception {
//    Map<String, String> parameter = new HashMap<>();
//    parameter.put("q", "Coffee");
//    parameter.put("location", "Austin, Texas");
//
//    SerpApiHttpClient stub = mock(SerpApiHttpClient.class);
//    when(stub.getResults(ArgumentMatchers.<String, String>anyMap())).thenReturn(
//        ReadJsonFile.readAsJson(Paths.get("src/test/java/serpapi/data/search_coffee_sample.json")).toString());
//
//    GoogleSearch search = new GoogleSearch(parameter);
//    search.search = stub;
//
//    assertEquals(3, search.getJson().getAsJsonArray("local_results").size());
//  }

  @Test
  public void searchCoffee() throws SerpApiSearchException {
    // skip test if no api_key provided
//    if (System.getenv("API_KEY") == null)
//      return;

    Map<String, String> parameter = new HashMap<>();
    parameter.put("engine", "google_shopping");
    parameter.put("q", "ps5");
    parameter.put("location", "Austin, Texas, United States");
    parameter.put("hl", "en");
    parameter.put("gl", "us");
    parameter.put("google_domain", "google.com");
    parameter.put("api_key", GoogleSearch.getApiKey());
    parameter.put("safe", "active");
    parameter.put("start", "1");
    parameter.put("num", "20");
    parameter.put("device", "desktop");

    GoogleSearch result = new GoogleSearch(parameter);
    JsonObject results = result.getJson();
    System.out.println(results.getAsJsonArray("shopping_results"));

    List<Product> products = new ArrayList<>();

    for (JsonElement item : results.getAsJsonArray("shopping_results") ) {
      Product  product = ProductConverter.toProduct(item.toString());
      products.add(product);
    }

    for (Product prod : products) {
      System.out.println(prod.toString());
    }

    //assertTrue(results.getAsJsonArray("organic_results").size() > 5);
  }

  @Test
  public void shoppingSearch() {
    Map<String, String> parameter = new HashMap<>();

    parameter.put("engine", "google_shopping");
    parameter.put("q", "Coffee");
    parameter.put("location", "Austin, Texas, United States");
    parameter.put("hl", "en");
    parameter.put("gl", "us");
    parameter.put("api_key", GoogleSearch.api_key_default);

    GoogleSearch search = new GoogleSearch(parameter);

    JsonObject results = null;
    try {
      results = search.getJson();
    } catch (SerpApiSearchException e) {
      throw new RuntimeException(e);
    }
    //System.out.println(results);

    System.out.println(results.get("shopping_results")); ;
    //System.out.println(shopping_results.getAsJsonArray().size());


  }

}
