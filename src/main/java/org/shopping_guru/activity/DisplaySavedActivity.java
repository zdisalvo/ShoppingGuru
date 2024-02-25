package org.shopping_guru.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shopping_guru.converters.ProductConverter;
import org.shopping_guru.dynamodb.UserCachingDao;
import org.shopping_guru.dynamodb.UserDao;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.User;
import org.shopping_guru.models.requests.DisplaySavedRequest;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class DisplaySavedActivity implements RequestHandler<DisplaySavedRequest, String> {

    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;
    //private final UserCachingDao userCachingDao;

    @Inject
    public DisplaySavedActivity(UserDao userDao) {
        this.userDao = userDao;
        //this.userCachingDao = userCachingDao;
    }

    @Override
    public String handleRequest(DisplaySavedRequest displaySavedRequest, Context context) {
        User user = new User();

        user = userDao.getUserByEmail(displaySavedRequest.getEmailOrIp());


        List<Product> products = new ArrayList<>();

        if (user.getWishList().size() > 0)
            products = user.getWishList();

        return ProductConverter.toJson(products);
    }
}
