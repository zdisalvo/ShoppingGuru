package org.shopping_guru.dependency;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;
import org.shopping_guru.util.DynamoDbClientProvider;

import javax.inject.Singleton;

@Module
public class DaoModule {

    @Provides
    @Singleton
    public DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
    }
}
