package org.shopping_guru.models.requests;

import org.shopping_guru.dynamodb.models.ProductReview;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;


public class ScrapeProductsRequestOrig {

    private static final AtomicLong ID_COUNTER = new AtomicLong(10000);

    private Long productId;
    private String productName;
    private String companyName;
    private Double productPrice;
    private ProductReview review;
    private String linkToProduct;
    private String linkToImage;

    public ScrapeProductsRequestOrig() {};

    public ScrapeProductsRequestOrig(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.companyName = builder.companyName;
        this.productPrice = builder.productPrice;
        this.review = builder.review;
        this.linkToProduct = builder.linkToProduct;
        this.linkToImage = builder.linkToImage;

    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public ProductReview getReview() {
        return review;
    }

    public void setReview(ProductReview review) {
        this.review = review;
    }

    public String getLinkToProduct() {
        return linkToProduct;
    }

    public void setLinkToProduct(String linkToProduct) {
        this.linkToProduct = linkToProduct;
    }

    public String getLinkToImage() {
        return linkToImage;
    }

    public void setLinkToImage(String linkToImage) {
        this.linkToImage = linkToImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrapeProductsRequestOrig)) return false;
        ScrapeProductsRequestOrig that = (ScrapeProductsRequestOrig) o;
        return Objects.equals(getProductId(), that.getProductId()) && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getCompanyName(), that.getCompanyName()) && Objects.equals(getProductPrice(), that.getProductPrice()) && Objects.equals(getReview(), that.getReview()) && Objects.equals(getLinkToProduct(), that.getLinkToProduct()) && Objects.equals(getLinkToImage(), that.getLinkToImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getCompanyName(), getProductPrice(), getReview(), getLinkToProduct(), getLinkToImage());
    }

    @Override
    public String toString() {
        return "ScrapeProductsRequest{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", productPrice=" + productPrice +
                ", review=" + review +
                ", linkToProduct='" + linkToProduct + '\'' +
                ", linkToImage='" + linkToImage + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private Long productId;
        private String productName;
        private String companyName;
        private Double productPrice;
        private ProductReview review;
        private String linkToProduct;
        private String linkToImage;

        public Builder withProductId() {
            this.productId = ID_COUNTER.getAndIncrement();
            return this;
        }

        public Builder withProductName(String productNameToUse) {
            this.productName = productNameToUse;
            return this;
        }

        public Builder withCompanyName(String companyNameToUse) {
            this.companyName = companyNameToUse;
            return this;
        }

        public Builder withProductPrice(Double productPriceToUse) {
            this.productPrice = productPriceToUse;
            return this;
        }

        public Builder withProductPrice(ProductReview productReviewToUse) {
            this.review = productReviewToUse;
            return this;
        }

        public Builder withLinkToProduct(String linkToProductToUse) {
            this.linkToProduct = linkToProductToUse;
            return this;
        }

        public Builder withLinkToImage(String linkToImageToUse) {
            this.linkToImage = linkToImageToUse;
            return this;
        }

        public ScrapeProductsRequestOrig build() {return new ScrapeProductsRequestOrig(this);}
    }
}
