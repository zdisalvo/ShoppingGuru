package org.shopping_guru.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.models.results.CreateUserResult;

public class CreateUserResponseConverter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJson(CreateUserResult createUserResult) {
        try {
            return MAPPER.writeValueAsString(createUserResult);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
