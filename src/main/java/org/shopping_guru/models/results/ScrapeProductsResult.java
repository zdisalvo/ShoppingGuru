package org.shopping_guru.models.results;

import org.shopping_guru.dynamodb.models.Product;


import java.util.List;

public class ScrapeProductsResult {

    private List<Product> products;

    public ScrapeProductsResult(Builder builder) {
        this.products = builder.products;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private List<Product> products;

        public Builder withProduct(List<Product> products) {
            this.products = products;
            return this;
        }

        public ScrapeProductsResult build() {return new ScrapeProductsResult(this);}
    }
}
