package org.shopping_guru.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.shopping_guru.converters.ModelConverter;
import org.shopping_guru.dynamodb.UserCachingDao;
import org.shopping_guru.dynamodb.UserDao;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.User;
import org.shopping_guru.exceptions.InvalidAttributeException;
import org.shopping_guru.models.UserModel;
import org.shopping_guru.models.requests.CreateUserRequest;
import org.shopping_guru.models.results.CreateUserResult;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.shopping_guru.util.CreateValidEmail;
import org.shopping_guru.util.CreateValidName;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateUserActivity implements RequestHandler<CreateUserRequest, CreateUserResult> {

    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;
    //private final UserCachingDao userCachingDao;

    @Inject
    public CreateUserActivity(UserDao userDao) {

        this.userDao = userDao;
        //this.userCachingDao = userCachingDao;
    }


    @Override
    public CreateUserResult handleRequest(CreateUserRequest createUserRequest, Context context) {
        log.info("Received CreateUserRequest {}", createUserRequest);

        User user = createUserWithEmail(createUserRequest);


            UserModel userModel = new ModelConverter().toUserModel(user);

            userDao.saveUser(user);

            return CreateUserResult.builder()
                    .withUser(userModel)
                    .build();
        }

        public User createUserWithEmail(CreateUserRequest createUserRequest) {

            //returns user with ip address as email or an empty new User object
            User user = userDao.getUserByEmail(createUserRequest.getIpAddress());

            List<Product> wishList = new ArrayList<>();

            user.setWishList(wishList);

            //already an existing user with the ipAddress - copies the wishlist over
            //and deletes the user tied to the ipAddress;
            if (user.getEmail() != null) {
                user.setWishList(user.getWishList());
                userDao.deleteUser(user);
            }

            if (CreateValidName.isValidName(createUserRequest.getFirstName()) &&
                    CreateValidName.isValidName(createUserRequest.getLastName())) {
                user.setFirstName(createUserRequest.getFirstName());
                user.setLastName(createUserRequest.getLastName());

            } else {
                throw new InvalidAttributeException("Name entry was invalid, only letters, spaces, dashes, and " +
                        "hyphens are allowed. You entered: " +
                        createUserRequest.getFirstName() + " " + createUserRequest.getLastName());
            }

            if (CreateValidEmail.isValidEmail(createUserRequest.getEmail())) {
                user.setEmail(createUserRequest.getEmail());
            } else {
                throw new InvalidAttributeException("Invalid email. You entered: " + createUserRequest.getEmail());
            }

            user.setPassword(createUserRequest.getPassword());

            return user;
        }

//        public User createUserWithIP(CreateUserRequest createUserRequest) {
//            User user = new User();
//
//            user.setEmail(createUserRequest.getEmail());
//
//            return user;
//
//        }
    }


