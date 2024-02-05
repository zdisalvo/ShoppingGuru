package org.shopping_guru.dynamodb;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.ProductIdCacheKey;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

public class ProductCachingDao {

    LoadingCache<Long, Product> productCache;

    @Inject
    public ProductCachingDao(final ProductDao delegateDao) {
        this.productCache = CacheBuilder.newBuilder()
                .maximumSize(2000)
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build(CacheLoader.from(delegateDao::getProductById));
    }

    public Product getProductById(Long productId) {
        return productCache.getUnchecked(productId);
    }
}
