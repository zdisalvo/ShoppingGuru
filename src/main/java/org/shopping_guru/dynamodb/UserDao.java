package org.shopping_guru.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.shopping_guru.dynamodb.models.User;
import org.shopping_guru.exceptions.UserNotFoundException;
import org.shopping_guru.util.DynamoDbClientProvider;

import javax.inject.Inject;
import java.util.ArrayList;

public class UserDao {

    private final DynamoDBMapper mapper;

    @Inject
    public UserDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public User getUserByEmail(String email) throws UserNotFoundException {

        User user = this.mapper.load(User.class, email);

        //TODO need to propogate this exception
        if (user == null) {
            return new User();
            //throw new UserNotFoundException("Could not find user with email: " + email);
        }

        return user;
    }

    public User getUserByIP(String ipAddress) {
        User user = this.mapper.load(User.class, ipAddress);

        if (user == null) {
            throw new UserNotFoundException("Could not find user with email: " + ipAddress);
        }

        return user;
    }

    public User saveUser(User user) {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());

        dynamoDBMapper.save(user);

        return user;
    }

    public User deleteUser(User user) {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());

        dynamoDBMapper.delete(user);

        return user;
    }
}
