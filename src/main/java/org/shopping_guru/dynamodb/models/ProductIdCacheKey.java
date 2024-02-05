package org.shopping_guru.dynamodb.models;

import java.util.Objects;

public class ProductIdCacheKey {

    private final String productId;

    public ProductIdCacheKey(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductIdCacheKey)) return false;
        ProductIdCacheKey that = (ProductIdCacheKey) o;
        return Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId());
    }


}
