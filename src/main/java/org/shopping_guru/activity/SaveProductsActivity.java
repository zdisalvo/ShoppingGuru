package org.shopping_guru.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shopping_guru.dynamodb.ProductCachingDao;
import org.shopping_guru.dynamodb.ProductDao;
import org.shopping_guru.dynamodb.UserCachingDao;
import org.shopping_guru.dynamodb.UserDao;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.User;
import org.shopping_guru.exceptions.UserNotFoundException;
import org.shopping_guru.models.requests.SaveProductsRequest;
import org.shopping_guru.models.requests.ScrapeProductsRequest;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class SaveProductsActivity implements RequestHandler<SaveProductsRequest, String> {

    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;
    private final UserCachingDao userCachingDao;
    private final ProductDao productDao;
    private final ProductCachingDao productCachingDao;

    @Inject
    public SaveProductsActivity(UserDao userDao, UserCachingDao userCachingDao, ProductDao productDao,
                                ProductCachingDao productCachingDao) {
        this.userDao = userDao;
        this.userCachingDao = userCachingDao;
        this.productDao = productDao;
        this.productCachingDao = productCachingDao;
    }


    @Override
    public String handleRequest(SaveProductsRequest saveProductsRequest, Context context) throws UserNotFoundException{

        User user = userCachingDao.getUserByEmail(saveProductsRequest.getEmailOrIp());

        if (user.getEmail() != null) {
            user = userCachingDao.getUserByEmail(saveProductsRequest.getEmailOrIp());
            if (user.getWishList() == null) user.setWishList(new ArrayList<>());
        } else {
            user.setEmail(saveProductsRequest.getEmailOrIp());
            user.setWishList(new ArrayList<>());
        }

//        try {
//            user = userCachingDao.getUserByEmail(saveProductsRequest.getEmailOrIp());
//            if (user.getWishList() == null) user.setWishList(new ArrayList<>());
//        } catch (UserNotFoundException e) {
//            user.setEmail(saveProductsRequest.getEmailOrIp());
//            user.setWishList(new ArrayList<>());
//        }

        Product product = productCachingDao.getProductById(saveProductsRequest.getProductId());

        List<Product> wishList = user.getWishList();
        wishList.add(product);

        user.setWishList(wishList);

        userDao.saveUser(user);

        return "Product Saved Successfully\n" + product.toString();
    }
}
