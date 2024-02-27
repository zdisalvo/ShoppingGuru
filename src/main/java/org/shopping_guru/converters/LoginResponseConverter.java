package org.shopping_guru.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.shopping_guru.models.results.CreateUserResult;
import org.shopping_guru.models.results.LoginResult;

public class LoginResponseConverter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static String toJson(LoginResult loginResult) {
        try {
            return MAPPER.writeValueAsString(loginResult);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
