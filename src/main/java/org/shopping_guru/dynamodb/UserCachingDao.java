package org.shopping_guru.dynamodb;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.shopping_guru.dynamodb.models.User;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

public class UserCachingDao {

    LoadingCache<String, User> userEmailCache;

    @Inject
    public UserCachingDao(final UserDao delegateDao) {
        this.userEmailCache = CacheBuilder.newBuilder()
                .maximumSize(2000)
                .expireAfterWrite(14, TimeUnit.DAYS)
                .build(CacheLoader.from(delegateDao::getUserByEmail));
    }

    public User getUserByEmail(String email) { return userEmailCache.getUnchecked(email);}


}
