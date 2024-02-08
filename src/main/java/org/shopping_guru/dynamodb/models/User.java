package org.shopping_guru.dynamodb.models;

import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.shopping_guru.converters.PreferencesListConverter;

@DynamoDBTable(tableName = "users")
public class User {


    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> preferences;
    private List<Product> wishList;



    @DynamoDBAttribute(attributeName = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBRangeKey(attributeName = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBHashKey(attributeName = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @DynamoDBTypeConverted(converter = PreferencesListConverter.class)
    @DynamoDBAttribute(attributeName = "preferences")
    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    //TODO DynamoDB Type Converter
    @DynamoDBAttribute(attributeName = "wishList")
    public List<Product> getWishList() {
        return wishList;
    }

    public void setWishList(List<Product> wishList) {
        this.wishList = wishList;
    }
}
