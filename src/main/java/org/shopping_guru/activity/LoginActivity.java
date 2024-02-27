package org.shopping_guru.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shopping_guru.converters.LoginResponseConverter;
import org.shopping_guru.converters.ProductConverter;
import org.shopping_guru.dynamodb.UserDao;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.User;
import org.shopping_guru.models.requests.DisplaySavedRequest;
import org.shopping_guru.models.requests.LoginRequest;
import org.shopping_guru.models.results.LoginResult;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity implements RequestHandler<LoginRequest, String> {

    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;


    @Inject
    public LoginActivity(UserDao userDao) {
        this.userDao = userDao;

    }

    @Override
    public String handleRequest(LoginRequest loginRequest, Context context) {

        User user = userDao.getUserByEmail(loginRequest.getEmail());

        LoginResult loginResult = new LoginResult();

        if (user.getEmail() == null) {
            loginResult.setStatus("unsuccessful");
            loginResult.setStatusCode(400, "A user does not exist with this email");
            return LoginResponseConverter.toJson(loginResult);
        }

        if (user.getPassword().equals(loginRequest.getPassword())) {
            loginResult.setStatus("successful");
        } else {
            loginResult.setStatus("unsuccessful");
            loginResult.setStatusCode(400, "Invalid Login");
        }

        return LoginResponseConverter.toJson(loginResult);
    }

}
