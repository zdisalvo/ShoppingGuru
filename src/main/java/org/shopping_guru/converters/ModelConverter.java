package org.shopping_guru.converters;

import org.shopping_guru.dynamodb.models.User;
import org.shopping_guru.models.UserModel;

public class ModelConverter {

    public UserModel toUserModel(User user) {

        return UserModel.builder()
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withWishList(user.getWishList())
                .build();
    }
}
