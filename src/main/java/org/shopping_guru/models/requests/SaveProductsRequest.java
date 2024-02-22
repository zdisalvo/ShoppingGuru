package org.shopping_guru.models.requests;

import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.User;

import java.util.Objects;

public class SaveProductsRequest {

    private String emailOrIp;
    private Long productId;

    public SaveProductsRequest(){}

    public SaveProductsRequest(Builder builder) {
        this.emailOrIp = builder.emailOrIp;
        this.productId = builder.productId;
    }

    public String getEmailOrIp() {
        return emailOrIp;
    }

    public void setEmailOrIp(String emailOrIp) {
        this.emailOrIp = emailOrIp;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaveProductsRequest)) return false;
        SaveProductsRequest that = (SaveProductsRequest) o;
        return Objects.equals(getEmailOrIp(), that.getEmailOrIp()) && Objects.equals(getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailOrIp(), getProductId());
    }

    @Override
    public String toString() {
        return "SaveProductsRequest{" +
                "emailOrIp='" + emailOrIp + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder{
        private String emailOrIp;
        private Long productId;

        public Builder withUser(String emailOrIpToUse) {
            this.emailOrIp = emailOrIpToUse;
            return this;
        }

        public Builder withProduct(Long productIdToUse) {
            this.productId = productIdToUse;
            return this;
        }

        public SaveProductsRequest build() {return new SaveProductsRequest(this);}
    }


}
