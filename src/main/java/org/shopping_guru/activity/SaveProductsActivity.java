package org.shopping_guru.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shopping_guru.converters.ProductConverter;
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
    //private final UserCachingDao userCachingDao;
    private final ProductDao productDao;
    private final ProductCachingDao productCachingDao;

    @Inject
    public SaveProductsActivity(UserDao userDao, ProductDao productDao,
                                ProductCachingDao productCachingDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.productCachingDao = productCachingDao;
    }


    /**
     *
     * @param saveProductsRequest The Lambda Function input
     * @param context The Lambda execution environment context object.
     * Method is synchronized so that multiple simultaneous requests
     * from the same user don't get confused
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public synchronized String handleRequest(SaveProductsRequest saveProductsRequest, Context context) throws UserNotFoundException{

        User user = userDao.getUserByEmail(saveProductsRequest.getEmailOrIp());

        if (saveProductsRequest.getSaving() == 1) {

            if (user.getEmail() != null) {
                user = userDao.getUserByEmail(saveProductsRequest.getEmailOrIp());
                if (user.getWishList() == null) user.setWishList(new ArrayList<>());
            } else {
                user.setEmail(saveProductsRequest.getEmailOrIp());
                user.setWishList(new ArrayList<>());
                userDao.saveUser(user);
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

            return ProductConverter.toJson(product);
        } else {
            Product product = productCachingDao.getProductById(saveProductsRequest.getProductId());

            List<Product> wishList = user.getWishList();

            for (int i = 0 ; i < wishList.size() ; i++) {
                if (wishList.get(i).getProductId().equals(product.getProductId())) {
                    wishList.remove(i);
                }
            }

            user.setWishList(wishList);

            userDao.saveUser(user);

            return ProductConverter.toJson(product);
        }
    }
}
