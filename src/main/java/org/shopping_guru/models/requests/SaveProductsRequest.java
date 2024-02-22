package org.shopping_guru.models.requests;

import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.User;

import java.util.Objects;

public class SaveProductsRequest {

    private String emailOrIp;
    private Long productId;
    private Integer saving;

    public SaveProductsRequest(){}

    public SaveProductsRequest(Builder builder) {
        this.emailOrIp = builder.emailOrIp;
        this.productId = builder.productId;
        this.saving = builder.saving;
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

    public Integer getSaving() {
        return saving;
    }

    public void setSaving(Integer saving) {
        this.saving = saving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaveProductsRequest)) return false;
        SaveProductsRequest that = (SaveProductsRequest) o;
        return Objects.equals(getEmailOrIp(), that.getEmailOrIp()) && Objects.equals(getProductId(), that.getProductId()) && Objects.equals(getSaving(), that.getSaving());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailOrIp(), getProductId(), getSaving());
    }

    @Override
    public String toString() {
        return "SaveProductsRequest{" +
                "emailOrIp='" + emailOrIp + '\'' +
                ", productId=" + productId +
                ", saving=" + saving +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder{
        private String emailOrIp;
        private Long productId;
        private Integer saving;


        public Builder withUser(String emailOrIpToUse) {
            this.emailOrIp = emailOrIpToUse;
            return this;
        }

        public Builder withProduct(Long productIdToUse) {
            this.productId = productIdToUse;
            return this;
        }

        public Builder withSaving(Integer savingTouse)  {
            this.saving = savingTouse;
            return this;
        }

        public SaveProductsRequest build() {return new SaveProductsRequest(this);}
    }


}
