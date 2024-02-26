package org.shopping_guru.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shopping_guru.converters.ProductConverter;
import org.shopping_guru.dynamodb.UserDao;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.User;
import org.shopping_guru.models.requests.DisplaySavedRequest;
import org.shopping_guru.models.requests.LoginRequest;

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
        User user = new User();

//        user = userDao.getUserByEmail(loginRequest.getEmailOrIp());


        List<Product> products = new ArrayList<>();

        if (user.getWishList().size() > 0)
            products = user.getWishList();

        return ProductConverter.toJson(products);
    }

}
