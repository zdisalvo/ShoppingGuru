package org.shopping_guru.converters;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.ProductOrig;


import java.io.IOException;

public class ProductConverter {

    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static Product toProduct(String json) {

        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            Product product = MAPPER.readValue(json, Product.class);
            return product;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String toJson(Product product) {
        try {
            return MAPPER.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
